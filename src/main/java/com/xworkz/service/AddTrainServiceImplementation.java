package com.xworkz.service;

import com.xworkz.dto.AddTrainDto;
import com.xworkz.dto.LocationDto;
import com.xworkz.dto.PriceDto;
import com.xworkz.dto.TimingDto;
import com.xworkz.entity.*;
import com.xworkz.repository.AddTrainRepository;
import com.xworkz.repository.LocationRepository;
import com.xworkz.repository.PriceRepository;
import com.xworkz.repository.TimingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddTrainServiceImplementation implements AddTrainService {
    @Autowired
    AddTrainRepository addTrainRepository;


    @Autowired
    LocationRepository locationRepository;
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    TimingRepository timingRepository;

    @Autowired
    TimingService timingService;

    @Override
    public boolean saveTrainTypeAndTrainNumber(AddTrainDto addTrainDto) {
        if (addTrainDto != null) {
            AddTrainEntity addTrainEntity1 = addTrainRepository.findByTrainNumberAndTrainType(addTrainDto.getTrainNumber(), addTrainDto.getTrainType());
            if (addTrainEntity1 == null) {
                AddTrainEntity addTrainEntity = new AddTrainEntity();
                BeanUtils.copyProperties(addTrainDto, addTrainEntity);
                addTrainRepository.saveTrainTypeAndNumber(addTrainEntity);
                return true;
            }
        }
        return false;
    }


    @Override
    public AddTrainDto findByTrainNumberAndTrainType(String trainNumber, String trainType) {
        if (trainNumber != null && trainType != null) {
            AddTrainDto addTrainDto = new AddTrainDto();
            AddTrainEntity addTrainEntity = addTrainRepository.findByTrainNumberAndTrainType(trainNumber, trainType);
            BeanUtils.copyProperties(addTrainEntity, addTrainDto);
            return addTrainDto;
        }
        return null;
    }

    @Override
        public List<AddTrainDto> readAddTrainData() {
        List<AddTrainEntity> addTrainEntities = addTrainRepository.readAddTrainDetails();

      List<AddTrainDto> addTrainDtoList=  addTrainEntities.stream().map(addTrainEntity -> {
            AddTrainDto  addTrainDto =new AddTrainDto();
            BeanUtils.copyProperties(addTrainEntity,addTrainDto);

            if (addTrainEntity.getLocations()!=null){
              List<LocationDto> locationDtoList =  addTrainEntity.getLocations().stream().map(locationEntity -> {
                    LocationDto locationDto =new LocationDto();
                    BeanUtils.copyProperties(locationEntity,locationDto);
                    return locationDto;
                }).collect(Collectors.toList());
              addTrainDto.setLocations(locationDtoList);
            }

          if (addTrainEntity.getPriceEntity() != null) {
             List<PriceDto> priceDtoList= addTrainEntity.getPriceEntity().stream().map(priceEntity -> {
                  PriceDto priceDto=new PriceDto();
                  BeanUtils.copyProperties(priceEntity,priceDto);
                  return priceDto;
              }).collect(Collectors.toList());
              addTrainDto.setPriceEntity(priceDtoList);
          }

          if (addTrainEntity.getTimingEntity()!=null){
             List<TimingDto> timingDtoList = addTrainEntity.getTimingEntity().stream().map(timingEntity -> {
                  TimingDto timingDto=new TimingDto();
                  BeanUtils.copyProperties(timingEntity,timingDto);
                  return timingDto;
              }).collect(Collectors.toList());
             addTrainDto.setTimingEntity(timingDtoList);
          }

           return addTrainDto;
        }).collect(Collectors.toList());

        log.info("List in repo {}",addTrainDtoList);
        return  addTrainDtoList;
    }


    @Override
    public AddTrainDto getTrainTypeService(String trainType) {
        if (trainType != null) {
            System.out.println(trainType);
            AddTrainDto addTrainDto = new AddTrainDto();
            AddTrainEntity addTrainEntity = addTrainRepository.findByTrainType(trainType);
            BeanUtils.copyProperties(addTrainEntity, addTrainDto);
            return addTrainDto;
        }
        return null;
    }

    @Override
    public AddTrainDto getDetails(Integer addTrainId) {
         if (addTrainId!=null){
             String id = String.valueOf(addTrainId);
             AddTrainDto addTrainDto = new AddTrainDto();
             AddTrainEntity addTrainEntity = addTrainRepository.findById(Integer.valueOf(id));
         log.info("addTrainEntity {}",addTrainEntity);
         if (addTrainEntity!=null){
             BeanUtils.copyProperties(addTrainEntity,addTrainDto);
             if (addTrainEntity.getTimingEntity()!=null){
                 List<TimingDto> timingDtoList = addTrainEntity.getTimingEntity().stream().map(timingEntity -> {
                     TimingDto timingDto=new TimingDto();
                     BeanUtils.copyProperties(timingEntity,timingDto);
                     return timingDto;
                 }).collect(Collectors.toList());
                 addTrainDto.setTimingEntity(timingDtoList);
             }
             if (addTrainEntity.getPriceEntity() != null) {
                 List<PriceDto> priceDtoList= addTrainEntity.getPriceEntity().stream().map(priceEntity -> {
                     PriceDto priceDto=new PriceDto();
                     BeanUtils.copyProperties(priceEntity,priceDto);
                     return priceDto;
                 }).collect(Collectors.toList());
                 addTrainDto.setPriceEntity(priceDtoList);
             }
             if (addTrainEntity.getLocations()!=null){
                 List<LocationDto> locationDtoList =  addTrainEntity.getLocations().stream().map(locationEntity -> {
                     LocationDto locationDto =new LocationDto();
                     BeanUtils.copyProperties(locationEntity,locationDto);
                     return locationDto;
                 }).collect(Collectors.toList());
                 addTrainDto.setLocations(locationDtoList);
             }
             return addTrainDto;
         }
         }
         return null;


    }

    @Override
    public AddTrainDto findByTrainNumber(String trainNumber) {
        if (trainNumber != null) {

            AddTrainDto addTrainDto = new AddTrainDto();
            AddTrainEntity addTrainEntity = addTrainRepository.findTrainNumber(trainNumber);
            BeanUtils.copyProperties(addTrainEntity, addTrainDto);
            return addTrainDto;
        }
        return null;
    }

    @Override
    public boolean updatingMetroDetails(String trainType,String trainNumber,String source,String destination,String fromTime,String toTime,Integer price,String dayOfTheWeek) {
        AddTrainDto addTrainDto = findByTrainNumber(trainNumber);
        AddTrainEntity addTrainEntity = addTrainRepository.findById(addTrainDto.getAddTrainId());
        log.info("This Me addTrainDto {}",addTrainDto);
        PriceEntity priceEntity = priceRepository.findById(addTrainDto.getAddTrainId());
        TimingEntity timingEntity = timingRepository.findById(addTrainDto.getAddTrainId());
        if (addTrainEntity.getAddTrainId().equals(addTrainDto.getAddTrainId())){
            addTrainEntity.setTrainType(trainType);
            addTrainEntity.setTrainNumber(trainNumber);
            addTrainRepository.savingTheUpdateDetails(addTrainEntity);
            if (addTrainDto.getAddTrainId().equals(priceEntity.getPriceId())){
                priceEntity.setPrice(price);
                priceRepository.savePriceToDataBase(priceEntity);
                if (addTrainDto.getAddTrainId().equals(timingEntity.getTimingId())){
                timingEntity.setSource(source);
                timingEntity.setDestination(destination);
                timingEntity.setFromTime(fromTime);
                timingEntity.setToTime(toTime);
                timingEntity.setDayOfTheWeek(dayOfTheWeek);
                timingRepository.TheUpdatedTimings(timingEntity);
                return true;
            }
        }             return true;

        }
            log.info("timingEntity*********************** {}",timingEntity);
        return false;
            }

}
