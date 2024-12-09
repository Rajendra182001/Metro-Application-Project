package com.xworkz.service;

import com.xworkz.dto.ReadDataDto;

import java.util.List;

public interface ReadDataService {
    List<ReadDataDto> readData();

    List<ReadDataDto> readAllData();

}
