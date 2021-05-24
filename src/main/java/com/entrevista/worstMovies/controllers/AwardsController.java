package com.entrevista.worstMovies.controllers;

import com.entrevista.worstMovies.models.AwardInterval;
import com.entrevista.worstMovies.services.AwardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/awardsInterval")
@AllArgsConstructor
public class AwardsController {
    private AwardsService awardsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, List<AwardInterval>> getProducerByAwardInterval() {
        return awardsService.getIntervalsMapping();
    }
}
