package com.etiya.core.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperManager implements ModelMapperService{
    private ModelMapper modelMapper;
    public ModelMapperManager(ModelMapper modelMapper){           //kullanmak icin injection yapiyoruz
        this.modelMapper = modelMapper;
    }
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);  //gevsek mapleme, her sey maplenmek zorunda degil
        return this.modelMapper;
    }
    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);  //request verildiginde tüm alanlarinin entity ile maplenmesi lazim
        return this.modelMapper;
    }
}