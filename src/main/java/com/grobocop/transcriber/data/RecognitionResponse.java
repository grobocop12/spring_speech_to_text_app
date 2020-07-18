package com.grobocop.transcriber.data;

import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;

import java.util.List;

public class RecognitionResponse {
    public enum Type {
        Error,
        Transcription,
        Empty
    }

    private List<SpeechRecognitionResult> results;
    private Type responseType;
    private int responseNumber;

    public RecognitionResponse(Type type) {
        this.responseType = type;
    }

    public RecognitionResponse(Type type, List<SpeechRecognitionResult> results) {
        this(type);
        this.results = results;
    }

    public List<SpeechRecognitionResult> getResults() {
        return results;
    }

    public void setResults(List<SpeechRecognitionResult> results) {
        this.results = results;
    }

    public Type getResponseType() {
        return responseType;
    }

    public void setResponseType(Type responseType) {
        this.responseType = responseType;
    }

    public int getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(int responseNumber) {
        this.responseNumber = responseNumber;
    }
}
