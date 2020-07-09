package com.grobocop.transcriber.controller;

import com.grobocop.transcriber.data.OutputDataPackage;

public interface SpeechRecognizerService {
    OutputDataPackage loadData(byte[] data);
}
