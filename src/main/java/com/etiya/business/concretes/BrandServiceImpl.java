package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateBrandRequest;
import com.etiya.business.dtos.responses.CreatedBrandResponse;
import com.etiya.business.dtos.responses.GetAllBrandResponse;
import com.etiya.core.utilities.mapping.ModelMapperService;
import com.etiya.dataAccess.abstracts.BrandRepository;
import com.etiya.dataAccess.concretes.BrandRepositoryImpl;
import com.etiya.entities.Brand;

import java.util.List;
import java.util.stream.Collectors;

public class BrandServiceImpl {      //BrandManager
    //son kullanicindan istenen alan, burda veri tabanindaki alani direkt kullaniciya vermis oluruz public Brand add(Brand brand){} bu sekilde kullanirsak bu nedenle dtolar kullaniyoruz
    //public Brand add(Brand brand){}  //kullanicidan ne entity istenir ne de entity verilir. Bu nedenle dto kullaniyoruz --response- request pattern

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    //dependency injection
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapperService modelMapperService) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest){
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);  //Brand.class Brand tipine cevir


        //repository newlenemez
        Brand createdBrand = brandRepository.add(brand);


        //response cevirmem lazim en nihayetinseo nedenle response nesnesi olusturdum
        //tüm alanlari tek tek setlemiycem--object mapper //-- mapping(field mapping) , reflection
        CreatedBrandResponse createdBrandResponse = this.modelMapperService.forResponse()
                .map(createdBrand,CreatedBrandResponse.class);
        return createdBrandResponse;
    }



    /*public List<Brand> getAll(){                         //veri tabani entity direkt kullanmis olcaktik, o nedenle response-request patternine uyarak yeni bir dto objesi olusturmam lazim
        return brandRepository.getAll();
    }*/

    public List<GetAllBrandResponse> getAll(){
        var result = brandRepository.getAll();      //getAll ile veri tabani bana brand listesi dönüyor,biz stream api ile foreach gibi döndürüp GetAllBrandResponse nesnesi listesi seklinde döndürdük

        List<GetAllBrandResponse> response = result.stream().map(brand ->   //js map(ecmascript)
                this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponse.class)).collect(Collectors.toList()); //alan(fiels) map, modelMapperService'teki map
        return response;
    }


}