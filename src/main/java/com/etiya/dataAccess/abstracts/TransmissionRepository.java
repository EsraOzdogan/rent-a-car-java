package com.etiya.dataAccess.abstracts;

import com.etiya.entities.Transmission;

import java.util.List;

public interface TransmissionRepository {
    Transmission add(Transmission transmission);
    List<Transmission> getAll();

}
