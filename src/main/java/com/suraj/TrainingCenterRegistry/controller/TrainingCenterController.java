package com.suraj.TrainingCenterRegistry.controller;

import com.suraj.TrainingCenterRegistry.model.TrainingCenter;
import com.suraj.TrainingCenterRegistry.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training-centers")
public class TrainingCenterController {

    @Autowired
    TrainingCenterService service;

    @PostMapping("/register")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        System.out.println("Post Request Has been hit");
        return ResponseEntity.ok(service.saveTrainingCenter(trainingCenter));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        System.out.println("Get Request Has been hit");
        return ResponseEntity.ok(service.getAllTrainingCenters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingCenter> getTrainingCenterById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTrainingCenterById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrainingCenter(@PathVariable Long id) {
        try {
            service.deleteTrainingCenter(id);
            return ResponseEntity.ok("Training center deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
