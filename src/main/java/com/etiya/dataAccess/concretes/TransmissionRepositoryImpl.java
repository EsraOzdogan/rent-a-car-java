package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.TransmissionRepository;
import com.etiya.entities.Transmission;

public class TransmissionRepositoryImpl implements TransmissionRepository {
    @Override
    public Transmission add(Transmission transmission) {
        System.out.println("Transmission added to TransmissionRepositoryImpl");

        transmission.setId(10);
        return transmission;
    }
}
