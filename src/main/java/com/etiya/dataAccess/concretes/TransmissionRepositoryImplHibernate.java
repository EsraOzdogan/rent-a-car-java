package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.TransmissionRepository;
import com.etiya.entities.Transmission;

import java.util.List;

public class TransmissionRepositoryImplHibernate implements TransmissionRepository {
    @Override
    public Transmission add(Transmission transmission) {
        System.out.println("Transmission added to TransmissionRepositoryImplHibernate");

        transmission.setId(11);
        return transmission;
    }

    @Override
    public List<Transmission> getAll() {
        return null;
    }
}
