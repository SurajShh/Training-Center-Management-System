package com.suraj.TrainingCenterRegistry.service;


import com.suraj.TrainingCenterRegistry.exception.DuplicateCenterCodeException;
import com.suraj.TrainingCenterRegistry.exception.DuplicateEmailException;
import com.suraj.TrainingCenterRegistry.model.TrainingCenter;
import com.suraj.TrainingCenterRegistry.repo.TrainingCenterRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingCenterService {
    private final TrainingCenterRepository repository;


    public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    public void validateEmail(String email) {
        if (email != null && !email.isBlank()) { 
            if (repository.existsByContactEmail(email)) {
                throw new DuplicateEmailException("Email already exists: " + email);
            }
        }
    }

    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {

        if (repository.existsByCenterCode(trainingCenter.getCenterCode())) {
            throw new DuplicateCenterCodeException("Center Code already exists: " + trainingCenter.getCenterCode());
        }

        validateEmail(trainingCenter.getContactEmail());

        // if (repository.existsByContactEmail(trainingCenter.getContactEmail())) {
        //     throw new DuplicateEmailException("Email already exists: " + trainingCenter.getContactEmail());
        // }

        
            if (repository.existsByContactPhone(trainingCenter.getContactPhone())) {
                throw new DuplicateEmailException("Phone Number already exists: " + trainingCenter.getContactPhone());
            }
        
        
        trainingCenter.setCreatedOn(LocalDateTime.now());
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }

    public TrainingCenter getTrainingCenterById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training center not found!"));
    }

    public void deleteTrainingCenter(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Training center not found!");
        }
        repository.deleteById(id);
    }
}

