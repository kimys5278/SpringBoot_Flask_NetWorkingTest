package com.springboot.flasktestserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.flasktestserver.dto.FlaskDto;
import com.springboot.flasktestserver.service.FlaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlaskController {
    private final FlaskService flaskService;

    private FlaskController(FlaskService flaskService){
        this.flaskService = flaskService;
    }

    @PostMapping("/flask")
    public String sendToFlask(@RequestBody FlaskDto flaskDto) throws JsonProcessingException{
        return flaskService.sendToFlask(flaskDto);
    }

}
