package com.proyecto.ips.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ChatGPTRequest {
    private String model;
    private Integer max_tokens;
    private List<Message>messages;
    private double temperature;

    public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
        this.setMax_tokens(60);
        this.setTemperature(0);
    }
}
