package com.etiya.entities;

import com.etiya.core.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Model extends BaseEntity<Integer> {
    private String name;
    private Brand brand;   //bir modelin bir markasi  var
    private List<Car> cars;  //bir modelde birden cok araba var
}