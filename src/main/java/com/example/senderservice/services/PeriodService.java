package com.example.senderservice.services;

import com.example.senderservice.models.entities.Period;
import com.example.senderservice.repos.PeriodRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vladimir Krasnov
 */
@Service
@RequiredArgsConstructor
public class PeriodService {
    private final PeriodRepo periodRepo;

    public void init(MultipartFile file){
        try {
            // Преобразование JSON из файла в список объектов Period
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            List<Period> periods = Arrays.asList(objectMapper.readValue(file.getBytes(), Period[].class));

            // Сохранение списка объектов в базу данных
            periodRepo.saveAll(periods);
        } catch (IOException e) {
            e.printStackTrace(); // Лучше обработать исключение согласно вашим требованиям
        }
    }
}
