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




}
