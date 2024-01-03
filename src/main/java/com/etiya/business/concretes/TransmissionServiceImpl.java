package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateTransmissionRequest;
import com.etiya.business.dtos.responses.*;
import com.etiya.core.utilities.mapping.ModelMapperService;
import com.etiya.dataAccess.abstracts.TransmissionRepository;
import com.etiya.entities.Transmission;

import java.util.List;
import java.util.stream.Collectors;

public class TransmissionServiceImpl {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    public  TransmissionServiceImpl(TransmissionRepository transmissionRepository, ModelMapperService modelMapperService){
        this.transmissionRepository = transmissionRepository;
        this.modelMapperService = modelMapperService;
    }

    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest){
        Transmission transmission  = this.modelMapperService.forRequest().map(createTransmissionRequest, Transmission.class);

        Transmission createdTransmission = transmissionRepository.add(transmission);

        CreatedTransmissionResponse createdTransmissionResponse = this.modelMapperService.forResponse()
                .map(createdTransmission,CreatedTransmissionResponse.class);

        return createdTransmissionResponse;
    }

    public List<GetAllTransmissionResponse> getAll(){
        var result = transmissionRepository.getAll();

        List<GetAllTransmissionResponse> response = result.stream().map(transmission ->
                this.modelMapperService.forResponse()
                        .map(transmission, GetAllTransmissionResponse.class)).collect(Collectors.toList());
        return response;
    }
}
