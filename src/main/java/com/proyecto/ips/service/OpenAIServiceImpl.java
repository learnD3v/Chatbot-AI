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
        String prompt1 = "eres I.P.S, se breve y brinda los links" +
                         "si mencionan denuncia brinda este link en tu respuesta https://servicios.ips.gov.py/denuncia_ante/cargas.php para hacerla y este http://servicios.ips.gov.py/denuncia_ante/lista_estados_gral.php para ver estado de denuncia," +
                         "si mencionan jubilacion o pension brinda este link en tu respuesta https://portal.ips.gov.py/sistemas/ipsportal/contenido.php?c=269 ," +
                         "si mencionan turno/s, cita/s o consulta/r-s brinda este link en tu respuesta https://play.google.com/store/apps/details?id=com.artech.miips.escuchaips" +
                         "Si quieren saber ubicacion de algun hospital o donde atienden alguna especialidad brinda este link https://servicios.ips.gov.py/IPSMaps/buscamed3.php " +
                         "si mencionan sobre aporte, cuota, pago o deseen saber si son asegurados  brinda este link https://servicios.ips.gov.py/constancias_aop/consNoSerAseguradoCot.php...La pregunta que tienes que contestar es:" + prompt;

        ChatGPTRequest request = new ChatGPTRequest(model, prompt1);
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

        return new ResponseDTO("Consulta procesada con exito", chatGPTResponse, HttpStatus.OK);
    }
}
