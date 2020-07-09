package com.grobocop.transcriber.data;

import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;

public class OutputDataPackage {
    private String outputMessage;

    public OutputDataPackage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }
}
