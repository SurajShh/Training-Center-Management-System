package com.suraj.TrainingCenterRegistry.repo;

import com.suraj.TrainingCenterRegistry.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long>{
    boolean existsByCenterCode(String centerCode);

    boolean existsByContactEmail(String contactEmail);

    boolean existsByContactPhone(String contactPhone);

}
