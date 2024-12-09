package com.xworkz.repository;

import com.xworkz.entity.TimingEntity;

import java.util.List;

public interface TimingRepository {

    public String saveTimingsFromRepo(TimingEntity timingEntity);

    TimingEntity findBySourceAndDestination(String source,String destination);

    List<TimingEntity> readTime();


    TimingEntity findByTrainType(String trainType);

    List<TimingEntity> findingSourceAndDestinations(String source,String destination);
}
