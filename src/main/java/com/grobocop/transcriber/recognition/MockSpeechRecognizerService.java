package com.grobocop.transcriber.recognition;

import com.grobocop.transcriber.controller.SpeechRecognizerService;
import com.grobocop.transcriber.data.RecognitionResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mockService")
public class MockSpeechRecognizerService implements SpeechRecognizerService {
    @Override
    public RecognitionResponse loadData(byte[] data) {
        return new RecognitionResponse(RecognitionResponse.Type.Empty);
    }
}
