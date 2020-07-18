package com.grobocop.transcriber.data;

public class InputDataPackage {
    private byte[] data;
    private int requestNumber;

    public InputDataPackage() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }
}
