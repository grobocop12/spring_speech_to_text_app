package com.grobocop.transcriber.controller;


import com.grobocop.transcriber.data.OutputDataPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;

@Controller
public class RecognizerController {

    @Autowired
    private SpeechRecognizerService speechRecognizerService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/voiceInput")
    public String voiceInput() {
        return "voiceInput";
    }

    @PostMapping("/transcribeAjax")
    public String transcribeAjax(@RequestBody String audio, Model model) {
        byte[] data = audio.split(",")[1].getBytes(StandardCharsets.US_ASCII);
        OutputDataPackage outputDataPackage = speechRecognizerService.loadData(data);
        model.addAttribute("output", outputDataPackage);
        return "transcriptionResult";
    }
}
