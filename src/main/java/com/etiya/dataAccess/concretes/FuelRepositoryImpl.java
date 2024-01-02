package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.FuelRepository;
import com.etiya.entities.Fuel;

public class FuelRepositoryImpl implements FuelRepository {
    @Override
    public Fuel add(Fuel fuel) {
        System.out.println("Fuel added to FuelRepositoryImpl");

        fuel.setId(10);
        return fuel;
    }
}
