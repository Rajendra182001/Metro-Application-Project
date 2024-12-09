package com.xworkz.repository;

import com.xworkz.entity.AddTrainEntity;
import com.xworkz.entity.RegistrationEntity;

import java.util.List;
import java.util.Optional;

public interface AddTrainRepository {
    public String saveTrainTypeAndNumber(AddTrainEntity addTrainEntity);

        AddTrainEntity findByTrainNumberAndTrainType(String trainNumber, String trainType);

    List<AddTrainEntity> readAddTrainDetails();

   AddTrainEntity findById(Integer addTrainId);

    AddTrainEntity findByTrainType(String trainType);

    AddTrainEntity findTrainNumber(String trainNumber);

}
