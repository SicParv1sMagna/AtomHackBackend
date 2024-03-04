package com.example.senderservice.repos;

import com.example.senderservice.models.entities.Period;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vladimir Krasnov
 */
public interface PeriodRepo extends JpaRepository<Period, Long> {
}
