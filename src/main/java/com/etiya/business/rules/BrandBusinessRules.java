package com.etiya.business.rules;

import com.etiya.dataAccess.abstracts.BrandRepository;

public class BrandBusinessRules {
    BrandRepository brandRepository;

    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void brandNameCanNotBeDuplicated(String name){
        this.brandRepository.getByName(name).ifPresent(brand->{               //ifPresent-- data varsa, observable gibi, ifPresentOrElse--data yoksa
            throw new RuntimeException("Brand name can not be duplicated. " + brand.getName());
        });
    }
}
