package com.grobocop.transcriber.controller;

import com.grobocop.transcriber.data.RecognitionResponse;

public interface SpeechRecognizerService {
    RecognitionResponse loadData(byte[] data);
}
