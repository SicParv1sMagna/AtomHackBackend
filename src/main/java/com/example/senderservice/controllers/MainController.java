package com.example.senderservice.controllers;

import com.example.senderservice.services.PeriodService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Vladimir Krasnov
 */
@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("")
@Tag(name = "Init periods API", description = "")
public class MainController {

    private final PeriodService periodService;
    @PostMapping("/init-periods")
    public ResponseEntity<?> init(@RequestParam(name = "file")MultipartFile file){
        periodService.init(file);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
