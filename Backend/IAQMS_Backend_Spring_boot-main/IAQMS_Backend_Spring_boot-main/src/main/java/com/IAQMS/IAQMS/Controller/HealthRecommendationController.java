package com.IAQMS.IAQMS.Controller;


import com.IAQMS.IAQMS.Service.HealthRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/iaq/health")
@CrossOrigin(origins = "http://localhost:3000")

public class HealthRecommendationController {


    @Autowired
    public HealthRecommendationService recommendationService;


    @GetMapping("/recommend")
    public List<String> getRecommendations(@RequestParam String condition){
        return recommendationService.getRecommendations(condition);
    }

}