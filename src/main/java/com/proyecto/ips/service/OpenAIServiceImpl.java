package com.proyecto.ips.service;

import com.proyecto.ips.dto.ChatGPTRequest;
import com.proyecto.ips.dto.ChatGPTResponse;
import com.proyecto.ips.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @Override
    public ResponseDTO chat(String prompt) {
        String prompt1 = prompt;

        ChatGPTRequest request = new ChatGPTRequest(model, prompt1);
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

        return new ResponseDTO("Consulta procesada con exito", chatGPTResponse, HttpStatus.OK);
    }
}
