package com.grobocop.transcriber.recognition;

import com.google.cloud.speech.v1p1beta1.*;
import com.google.protobuf.ByteString;
import com.grobocop.transcriber.controller.SpeechRecognizerService;
import com.grobocop.transcriber.data.RecognitionResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Qualifier("speechRecognizerService")
public class SpeechRecognizerServiceImpl implements SpeechRecognizerService {

    private SpeechClient client;
    private final RecognitionConfig recognitionConfig =
            RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.MP3)
                    .setLanguageCode("en-US")
                    .setSampleRateHertz(16000)
                    .build();

    @PostConstruct
    private void setUpRecognizer() {
        try {
            client = SpeechClient.create();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public RecognitionResponse loadData(byte[] data) {
        ByteString byteString = ByteString.copyFrom(data);
        RecognitionAudio request = RecognitionAudio
                .newBuilder()
                .setContent(byteString)
                .build();
        try {
            RecognizeResponse response = client.recognize(recognitionConfig, request);
            List<SpeechRecognitionResult> results = response.getResultsList();
            if (results.size() > 0) {
                return new RecognitionResponse(RecognitionResponse.Type.Transcription, results);
            } else {
                return new RecognitionResponse(RecognitionResponse.Type.Empty, results);
            }
        } catch (Exception e) {
            return new RecognitionResponse(RecognitionResponse.Type.Error);
        }
    }
}
