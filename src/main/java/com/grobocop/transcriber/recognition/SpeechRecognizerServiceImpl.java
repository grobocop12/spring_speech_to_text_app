package com.grobocop.transcriber.recognition;

import com.google.cloud.speech.v1p1beta1.*;
import com.google.protobuf.ByteString;
import com.grobocop.transcriber.controller.SpeechRecognizerService;
import com.grobocop.transcriber.data.OutputDataPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope(value = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SpeechRecognizerServiceImpl implements SpeechRecognizerService {

    private SpeechClient client;

    @PostConstruct
    private void setUpRecognizer() {
        try {
            client = SpeechClient.create();
            RecognitionConfig recognitionConfig =
                    RecognitionConfig.newBuilder()
                            .setEncoding(RecognitionConfig.AudioEncoding.MP3)
                            .setLanguageCode("en-US")
                            .setSampleRateHertz(16000)
                            .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public OutputDataPackage loadData(byte[] data) {
        try {
            ByteString byteString = ByteString.copyFrom(data);
            RecognitionAudio request =
                    RecognitionAudio.newBuilder().setContent(byteString).build();
            RecognitionConfig recognitionConfig =
                    RecognitionConfig.newBuilder()
                            .setEncoding(RecognitionConfig.AudioEncoding.MP3)
                            .setLanguageCode("en-US")
                            .setSampleRateHertz(16000)
                            .build();
            RecognizeResponse response = client.recognize(recognitionConfig, request);
            if(response.getResults(0).getAlternatives(0) != null) {
                String result = response.getResults(0).getAlternatives(0).getTranscript();
                return new OutputDataPackage(result);
            } else {
                return new OutputDataPackage("");
            }
        } catch (Exception e) {
            return new OutputDataPackage(null);
        }
    }
}
