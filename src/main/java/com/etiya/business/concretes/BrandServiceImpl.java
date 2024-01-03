package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateBrandRequest;
import com.etiya.business.dtos.responses.CreatedBrandResponse;
import com.etiya.business.dtos.responses.GetAllBrandResponse;
import com.etiya.dataAccess.abstracts.BrandRepository;
import com.etiya.dataAccess.concretes.BrandRepositoryImpl;
import com.etiya.entities.Brand;

import java.util.List;
import java.util.stream.Collectors;

public class BrandServiceImpl {      //BrandManager
    //son kullanicindan istenen alan, burda veri tabanindaki alani direkt kullaniciya vermis oluruz public Brand add(Brand brand){} bu sekilde kullanirsak bu nedenle dtolar kullaniyoruz
    //public Brand add(Brand brand){}  //kullanicidan ne entity istenir ne de entity verilir. Bu nedenle dto kullaniyoruz --response- request pattern

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

        //response cevirmem lazim en nihayetinseo nedenle response nesnesi olusturdum
        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();    //tüm alanlari tek tek setlemiycem--object mapper //-- mapping(field mapping) , reflection
        createdBrandResponse.setId(createdBrand.getId());
        createdBrandResponse.setName(createdBrand.getName());
        createdBrandResponse.setCreatedDate(createdBrand.getCreatedDate());

        return createdBrandResponse;
    }



    /*public List<Brand> getAll(){                         //veri tabani entity direkt kullanmis olcaktik, o nedenle response-request patternine uyarak yeni bir dto objesi olusturmam lazim
        return brandRepository.getAll();
    }*/

    public List<GetAllBrandResponse> getAll(){
        var result = brandRepository.getAll();      //getAll ile veri tabani bana brand listesi dönüyor,biz stream api ile foreach gibi döndürüp GetAllBrandResponse nesnesi listesi seklinde döndürdük

        List<GetAllBrandResponse> response = result.stream().map(brand -> {
            GetAllBrandResponse currentBrand = new GetAllBrandResponse();
            currentBrand.setId(brand.getId());
            currentBrand.setName(brand.getName());
            currentBrand.setCreatedDate(brand.getCreatedDate());
            //result.add(currentBrand);
            return currentBrand;
        }).collect(Collectors.toList());

        //.collect(Collectors.toList());    ---- Stream'i List'e cevirir
        return response;
    }


}