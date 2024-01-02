package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateTransmissionRequest;
import com.etiya.business.dtos.responses.CreatedTransmissionResponse;
import com.etiya.dataAccess.abstracts.TransmissionRepository;
import com.etiya.entities.Transmission;

public class TransmissionServiceImpl {
    private TransmissionRepository transmissionRepository;
    public  TransmissionServiceImpl(TransmissionRepository transmissionRepository){
        this.transmissionRepository = transmissionRepository;
    }

    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest){
        Transmission transmission = new Transmission();
        transmission.setName(createTransmissionRequest.getName());

        Transmission createdTransmission = transmissionRepository.add(transmission);

        CreatedTransmissionResponse createdTransmissionResponse = new CreatedTransmissionResponse();
        createdTransmissionResponse.setId(createdTransmission.getId());
        createdTransmissionResponse.setName(createdTransmission.getName());
        createdTransmissionResponse.setCreatedDate(createdTransmission.getCreatedDate());

        return createdTransmissionResponse;
    }
}
