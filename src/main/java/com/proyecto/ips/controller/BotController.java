package com.proyecto.ips.controller;

import com.proyecto.ips.dto.ResponseDTO;
import com.proyecto.ips.service.OpenAIService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
@AllArgsConstructor
public class BotController {

    private final OpenAIService openAIService;

    @GetMapping("/chat")
    public ResponseEntity<ResponseDTO> chatbot(@RequestParam String prompt){
        return openAIService.chat(prompt).build();
    }
}
