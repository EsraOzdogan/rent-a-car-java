package com.etiya.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    //yüm alanlar mimaplenecek?
    ModelMapper forResponse();
    ModelMapper forRequest();
}