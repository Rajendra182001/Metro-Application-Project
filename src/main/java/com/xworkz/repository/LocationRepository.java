package com.xworkz.repository;

import com.xworkz.entity.LocationEntity;
import com.xworkz.entity.PriceEntity;

import java.util.List;

public interface LocationRepository {

    public String onLocationSave(LocationEntity locationEntity);

    LocationEntity findByTrainNumber(String trainNumber);

    List<LocationEntity> readLocation();

    LocationEntity findByTrainType(String trainType);


}
