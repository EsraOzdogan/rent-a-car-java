package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.BrandRepository;
import com.etiya.entities.Brand;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//islem yapan sınıflarda sınıf implemente edilmemis ya da extend edilmemisse ilerde problem yasanir
public class BrandRepositoryImpl implements BrandRepository {   //BrandRepository, BrandRepositoryImpl'nin referansini tutar //implements ya da extends farketmez

    //veri tabani  gitmeden stream, collection ile calisma
    List<Brand> brands;  //typesafe, array //veri tabani olmadigi icin simdi burda list olusturduk(in memory)

    public  BrandRepositoryImpl(){  //constructor
        Brand brand1 = new Brand();
        brand1.setId(1);
        brand1.setName("BMW");
        brand1.setCreatedDate(LocalDateTime.now());

        Brand brand2 = new Brand();
        brand2.setId(2);
        brand2.setName("Audi");
        brand2.setCreatedDate(LocalDateTime.now());

        Brand brand3 = new Brand();
        brand3.setId(3);
        brand3.setName("Mercedes");
        brand3.setCreatedDate(LocalDateTime.now());

        brands = new ArrayList<>();  //brands = new List<>();  olmaz cünkü List interfacedir ve newlenemez
        // brands.add(new Brand(1,"BMW"...)
        brands.add(brand1);
        brands.add(brand2);
        brands.add(brand3);

    }

    @Override
    public Brand add(Brand brand){       //void yerine Brand yazildi Brand dönderecegi icin orm  //Repository-- direkt veri tabani erisimini anlatir. Veri tabaniyle ayni sistem olmali.O nedenle burda Brand kullandik parametre olarak veri tabani nesnesi kullandik
        //Jpa kodları
        System.out.println("Brand added to db by BrandRepositoryImpl");
        brand.setId((int)Math.random());
        brands.add(brand);
        return brand;         //veri tabaninda olusmus brandi dönderiyoruz
    }


    @Override
    public List<Brand> getAll() {
        return brands;
    }
}