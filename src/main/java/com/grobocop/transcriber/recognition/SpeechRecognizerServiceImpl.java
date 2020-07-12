package com.grobocop.transcriber.recognition;

import com.google.cloud.speech.v1p1beta1.*;
import com.google.protobuf.ByteString;
import com.grobocop.transcriber.controller.SpeechRecognizerService;
import com.grobocop.transcriber.data.OutputDataPackage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class SpeechRecognizerServiceImpl implements SpeechRecognizerService {

    private SpeechClient client;

    @PostConstruct
    private void setUpRecognizer() {
        try {
            client = SpeechClient.create();
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
                            .setEncoding(RecognitionConfig.AudioEncoding.AMR_WB)
                            .setLanguageCode("en-US")
                            .setSampleRateHertz(16000)
                            .build();
            RecognizeResponse response = client.recognize(recognitionConfig, request);
            List<SpeechRecognitionResult> results = response.getResultsList();
            if (results.size() > 0) {
                String result = results.get(0).getAlternatives(0).toString();
                System.out.println(result);
                return new OutputDataPackage(result);
            } else {
                return new OutputDataPackage("NONE" +
                        "");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new OutputDataPackage(e.getMessage());
        }
    }
}
