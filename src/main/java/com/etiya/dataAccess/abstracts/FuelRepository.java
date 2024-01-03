package com.etiya.dataAccess.abstracts;

import com.etiya.entities.Fuel;

import java.util.List;

public interface FuelRepository {
    Fuel add(Fuel fuel);
    List<Fuel> getAll();
}
