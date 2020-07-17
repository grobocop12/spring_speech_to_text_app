package com.grobocop.transcriber.controller;


import com.grobocop.transcriber.data.InputDataPackage;
import com.grobocop.transcriber.data.RecognitionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class RecognizerController {

    @Autowired
    @Qualifier("speechRecognizerService")
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
    public String transcribeAjax(@RequestBody InputDataPackage input, Model model) {
        RecognitionResponse recognitionResponse = speechRecognizerService.loadData(input.getData());
        model.addAttribute("output", recognitionResponse);
        return "transcriptionResult";
    }
}
