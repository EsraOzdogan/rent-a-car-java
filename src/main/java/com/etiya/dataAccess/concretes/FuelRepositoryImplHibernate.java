package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.FuelRepository;
import com.etiya.entities.Fuel;

import java.util.List;

public class FuelRepositoryImplHibernate implements FuelRepository {
    @Override
    public Fuel add(Fuel fuel) {
        System.out.println("Fuel added to FuelRepositoryImplHibernate");

        fuel.setId(11);
        return fuel;
    }

    @Override
    public List<Fuel> getAll() {
        return null;
    }
}
