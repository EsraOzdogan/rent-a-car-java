package com.etiya.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedBrandResponse {
    private int id;   //kullanicinin marka detayina gitmesi icin responseda id veriyoruz
    private String name;
    private LocalDateTime createdDate;
}