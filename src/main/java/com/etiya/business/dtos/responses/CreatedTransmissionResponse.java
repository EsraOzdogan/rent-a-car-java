package com.etiya.business.dtos.responses;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatedTransmissionResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}
