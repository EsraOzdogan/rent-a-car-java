package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.FuelRepository;
import com.etiya.entities.Fuel;

import java.util.List;

public class FuelRepositoryImpl implements FuelRepository {
    @Override
    public Fuel add(Fuel fuel) {
        System.out.println("Fuel added to FuelRepositoryImpl");

        fuel.setId(10);
        return fuel;
    }

    @Override
    public List<Fuel> getAll() {

        return null;
    }
}
