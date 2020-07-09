package com.grobocop.transcriber.controller;

import com.grobocop.transcriber.data.InputDataPackage;
import com.grobocop.transcriber.data.OutputDataPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.Base64;

@Controller
public class RecognizerWebsocketController {
    @Autowired
    private SpeechRecognizerService client;

    @MessageMapping("/dataInput")
    @SendToUser("/dataOutput/output")
    public OutputDataPackage voiceDataInput(@Payload InputDataPackage inputDataPackage) {
        byte[] data = Base64.getDecoder().decode(inputDataPackage.getData().split(",")[1]);
        OutputDataPackage result = client.loadData(data);
        return result;
    }

    @MessageExceptionHandler
    @SendToUser("/dataOutput/errors")
    public String handleException(Throwable exception) {
        System.out.println(exception.getMessage());
        return exception.getMessage();
    }

}
