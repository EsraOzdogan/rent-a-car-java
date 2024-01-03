package com.etiya.business.dtos.responses;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllTransmissionResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}
