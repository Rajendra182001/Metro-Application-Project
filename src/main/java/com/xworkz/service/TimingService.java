package com.xworkz.service;

import com.xworkz.dto.LocationDto;
import com.xworkz.dto.TimingDto;

import java.util.List;

public interface TimingService {

    public boolean saveTimings(TimingDto timingDto);
    TimingDto findBySourceAndDestination(String source,String destination);

    List<TimingDto> readTime();

    TimingDto findByTrainType(String trainType);

    List<TimingDto> findBySourceAndDestinations(String source,String destination);

}
