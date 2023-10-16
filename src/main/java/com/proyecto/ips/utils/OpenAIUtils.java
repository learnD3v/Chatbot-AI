package com.proyecto.ips.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
@Getter
@Setter
public class OpenAIUtils {
    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    private RestTemplate template;

}
