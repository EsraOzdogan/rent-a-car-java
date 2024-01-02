package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.FuelRepository;
import com.etiya.entities.Fuel;

public class FuelRepositoryImplHibernate implements FuelRepository {
    @Override
    public Fuel add(Fuel fuel) {
        System.out.println("Fuel added to FuelRepositoryImplHibernate");

        fuel.setId(11);
        return fuel;
    }
}
