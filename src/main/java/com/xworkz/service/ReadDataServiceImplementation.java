package com.xworkz.service;

import com.xworkz.dto.ReadDataDto;
import com.xworkz.entity.*;
import com.xworkz.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class ReadDataServiceImplementation implements ReadDataService {

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    TimingRepository timingRepository;
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    AddTrainRepository addTrainRepository;
    @Autowired
    ReadDataRepository readDataRepository;

    @Override
    public List<ReadDataDto> readData() {
//        List<AddTrainEntity> addTrainEntities = addTrainRepository.readAddTrainDetails();
//        List<LocationEntity> locationEntities = locationRepository.readLocation();
//        List<TimingEntity> timingEntities = timingRepository.readTime();
//        List<PriceEntity> priceEntities = priceRepository.readPrice();
//        List<ReadDataDto> result = locationEntities.stream()
//                .flatMap(location -> timingEntities.stream()
//                        .flatMap(timing -> addTrainEntities.stream()
//                                .flatMap(addTrain -> priceEntities.stream()
//                                        .filter(price ->
//                                                addTrain.getAddTrainId().equals(location.getLocationId())
//                                                        && addTrain.getAddTrainId().equals(timing.getTimingId())
//                                                        && addTrain.getAddTrainId().equals(price.getPriceId())
//                                        )
//                                        .map(price -> {
//                                            ReadDataDto dto = new ReadDataDto();
//                                            BeanUtils.copyProperties(addTrain, dto);
//                                            BeanUtils.copyProperties(location, dto);
//                                            BeanUtils.copyProperties(timing, dto);
//                                            BeanUtils.copyProperties(price, dto);
//                                            return dto;
//                                        })
//                                )
//                        )
//                )
//                .distinct()
//                .collect(Collectors.toList());
//        result.forEach(dto -> System.out.println(dto));
        return Collections.emptyList();

    }

    @Override
    public List<ReadDataDto> readAllData() {
        List<ReadDataEntity> readDataEntities = readDataRepository.readFromDataBase();
        List<ReadDataDto> listOfDto = new ArrayList<>();

    return null;
    }

}
