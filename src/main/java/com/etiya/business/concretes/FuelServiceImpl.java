package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateFuelRequest;
import com.etiya.business.dtos.responses.CreatedFuelResponse;
import com.etiya.dataAccess.abstracts.FuelRepository;
import com.etiya.entities.Fuel;

public class FuelServiceImpl {

    private FuelRepository fuelRepository;
    public  FuelServiceImpl(FuelRepository fuelRepository){
        this.fuelRepository = fuelRepository;
    }

    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest){
        Fuel fuel = new Fuel();
        fuel.setName(createFuelRequest.getName());

        Fuel createdFuel = fuelRepository.add(fuel);

        CreatedFuelResponse createdFuelResponse = new CreatedFuelResponse();
        createdFuelResponse.setId(createdFuel.getId());
        createdFuelResponse.setName(createdFuel.getName());
        createdFuelResponse.setCreatedDate(createdFuel.getCreatedDate());

        return createdFuelResponse;
    }

}
