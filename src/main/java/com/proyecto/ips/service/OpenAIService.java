package com.proyecto.ips.service;

import com.proyecto.ips.dto.ResponseDTO;

public interface OpenAIService {
    ResponseDTO chat(String prompt);
}
