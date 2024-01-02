package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.BrandRepository;
import com.etiya.entities.Brand;

public class BrandRepositoryImpl implements BrandRepository {   //BrandRepository, BrandRepositoryImpl'nin referansini tutar //implements ya da extends farketmez

    @Override
    public Brand add(Brand brand){       //void yerine Brand yazildi Brand dönderecegi icin orm  //Repository-- direkt veri tabani erisimini anlatir. Veri tabaniyle ayni sistem olmali.O nedenle burda Brand kullandik parametre olarak veri tabani nesnesi kullandik
        //Jpa kodları
        System.out.println("Brand added to db by BrandRepositoryImpl");
        brand.setId(10);
        return brand;         //veri tabaninda olusmus brandi dönderiyoruz
    }
}