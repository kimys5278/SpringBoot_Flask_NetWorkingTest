package com.springboot.flasktestserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.flasktestserver.dto.FlaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class FlaskService {

    private final ObjectMapper objectMapper;
    @Transactional
    public String sendToFlask(FlaskDto flaskDto)throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        //헤더를 JSON형식으로 설정
        HttpHeaders headers = new HttpHeaders();

        //파라미터로 들어온 dto를 JSON 객체로 변환
        headers.setContentType(MediaType.APPLICATION_JSON);

        String param = objectMapper.writeValueAsString(flaskDto);

        HttpEntity<String> entity = new HttpEntity<String>(param,headers);

        String url = "http://127.0.0.1:5000/receive_string";

        return  restTemplate.postForObject(url,entity,String.class);

    }

}
