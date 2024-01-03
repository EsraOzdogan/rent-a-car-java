package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateFuelRequest;
import com.etiya.business.dtos.responses.CreatedFuelResponse;
import com.etiya.business.dtos.responses.GetAllFuelResponse;
import com.etiya.core.utilities.mapping.ModelMapperService;
import com.etiya.dataAccess.abstracts.FuelRepository;
import com.etiya.entities.Fuel;

import java.util.List;
import java.util.stream.Collectors;

public class FuelServiceImpl {

    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    public  FuelServiceImpl(FuelRepository fuelRepository, ModelMapperService modelMapperService){
        this.fuelRepository = fuelRepository;
        this.modelMapperService = modelMapperService;
    }

    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest){
        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);
        Fuel createdFuel = fuelRepository.add(fuel);

        CreatedFuelResponse createdFuelResponse = this.modelMapperService.forResponse()
                .map(createdFuel,CreatedFuelResponse.class);

        return createdFuelResponse;
    }

    public List<GetAllFuelResponse> getAll(){
        var result = fuelRepository.getAll();

        List<GetAllFuelResponse> response = result.stream().map(fuel ->
                this.modelMapperService.forResponse()
                        .map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
        return response;
    }

}
