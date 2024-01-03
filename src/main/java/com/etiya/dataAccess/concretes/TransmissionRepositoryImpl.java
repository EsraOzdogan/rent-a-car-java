package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.TransmissionRepository;
import com.etiya.entities.Transmission;

import java.util.List;

public class TransmissionRepositoryImpl implements TransmissionRepository {
    @Override
    public Transmission add(Transmission transmission) {
        System.out.println("Transmission added to TransmissionRepositoryImpl");

        transmission.setId(10);
        return transmission;
    }

    @Override
    public List<Transmission> getAll() {
        return null;
    }
}
