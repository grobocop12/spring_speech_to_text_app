package com.grobocop.transcriber.controller;


import com.grobocop.transcriber.data.InputDataPackage;
import com.grobocop.transcriber.data.OutputDataPackage;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public String transcribeAjax(@RequestBody InputDataPackage input, Model model) {
        //byte[] data = //audio.split(",")[1].getBytes(StandardCharsets.UTF_8);// Base64.getDecoder().decode();


            OutputDataPackage outputDataPackage = speechRecognizerService.loadData(input.getData());
            model.addAttribute("output", outputDataPackage);

        return "transcriptionResult";
    }
}
