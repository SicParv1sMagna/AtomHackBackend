package com.example.senderservice.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Vladimir Krasnov
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Double speed;

    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", lenient = OptBoolean.TRUE)
    @Column(name = "start_time")
    private LocalDateTime from;

    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", lenient = OptBoolean.TRUE)
    @Column(name = "end_time")
    private LocalDateTime to;
}
