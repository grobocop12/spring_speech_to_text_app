package com.grobocop.transcriber.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecognizerController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/voiceInput")
    public String voiceInput() {
        return "voiceInput";
    }
}
