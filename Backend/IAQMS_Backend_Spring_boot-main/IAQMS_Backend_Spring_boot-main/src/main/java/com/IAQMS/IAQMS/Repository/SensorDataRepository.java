package com.IAQMS.IAQMS.Repository;

import com.IAQMS.IAQMS.Model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    SensorData findTopByOrderByIdDesc();
}
