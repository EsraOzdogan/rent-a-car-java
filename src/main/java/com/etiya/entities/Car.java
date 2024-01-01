package com.etiya.entities;

import com.etiya.core.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car extends BaseEntity<Integer> {
    private String plate;
    private double dailyPrice;
    private Model model;  //private  String modelId; bunu vermeye gerek yok artık
    private Transmission transmission;  //private String transmissionId; bunu vermeye gerek yok artık
    private Fuel fuel;   //private  String fuelId; bunu vermeye gerek yok artık


}