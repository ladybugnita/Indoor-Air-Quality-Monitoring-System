package com.IAQMS.IAQMS.Repository;

import com.IAQMS.IAQMS.Model.FeedbackData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackData , Long> {
    FeedbackData findTopByOrderByIdDesc();
}
