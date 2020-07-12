package com.grobocop.transcriber.data;

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
