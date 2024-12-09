package com.xworkz.service;

import com.xworkz.dto.AddTrainDto;
import com.xworkz.entity.AddTrainEntity;

import java.util.List;
import java.util.Optional;

public interface AddTrainService {

     boolean saveTrainTypeAndTrainNumber(AddTrainDto addTrainDto);

    AddTrainDto findByTrainNumberAndTrainType(String trainNumber, String trainType);

    List<AddTrainDto> readAddTrainData();


    //Optional<AddTrainEntity> findById(Integer addTrainId);
    AddTrainDto getTrainTypeService(String trainType);

    AddTrainEntity getDetails(Integer addTrainId);

    AddTrainDto findByTrainNumber(String trainNumber);
}
