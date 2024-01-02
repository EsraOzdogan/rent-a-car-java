package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateBrandRequest;
import com.etiya.business.dtos.responses.CreatedBrandResponse;
import com.etiya.dataAccess.abstracts.BrandRepository;
import com.etiya.dataAccess.concretes.BrandRepositoryImpl;
import com.etiya.entities.Brand;

public class BrandServiceImpl {      //BrandManager
    //son kullanicindan istenen alan, burda veri tabanindaki alani direkt kullaniciya vermis oluruz bu nedenle dtolar kullaniyoruz
    //public Brand add(Brand brand){}

    private BrandRepository brandRepository;
    //dependency injection
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest){
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        //repository newlenemez
        //BrandRepositoryImpl repository = new BrandRepositoryImpl();
        //Brand createdBrand = repository.add(brand);

        Brand createdBrand = brandRepository.add(brand);

        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();    //veri tabani bana brand dönderiyor ama ben kullaniciya sadece belli alanlari dönderiyorum-- mapping(field mapping)
        createdBrandResponse.setId(createdBrand.getId());
        createdBrandResponse.setName(createdBrand.getName());
        createdBrandResponse.setCreatedDate(createdBrand.getCreatedDate());

        return createdBrandResponse;
    }
}