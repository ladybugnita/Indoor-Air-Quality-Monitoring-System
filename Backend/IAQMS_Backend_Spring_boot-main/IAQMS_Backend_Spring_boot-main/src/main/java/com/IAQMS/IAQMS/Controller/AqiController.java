package com.IAQMS.IAQMS.Controller;


import com.IAQMS.IAQMS.Model.SensorData;
import com.IAQMS.IAQMS.Repository.SensorDataRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/iaq/data")
@CrossOrigin(origins = "http://localhost:3000")

public class AqiController {


    private final SensorDataRepository sensorDataRepository;

    public AqiController(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @PostMapping
    public ResponseEntity<String> receivedData(@RequestBody SensorData data){

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Kathmandu"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        String formattedTime = now.format(formatter);

        data.setTimestamp(formattedTime);
        sensorDataRepository.save(data);
        System.out.println("received data :" +data);
        return ResponseEntity.ok("data received" +data);
    }

    @GetMapping("/latest")
    public ResponseEntity<SensorData> getLatestData(){
        SensorData latest = sensorDataRepository.findTopByOrderByIdDesc();
        return ResponseEntity.ok(latest);
    }
}
