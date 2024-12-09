package com.xworkz.service;

import com.xworkz.dto.LocationDto;

import java.util.List;

public interface LocationService {

    public boolean onSaveLocationAndType(LocationDto locationDto);

    LocationDto findByTrainNumber(String trainNumber);

    List<LocationDto> readLocation();

}
