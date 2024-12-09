package com.xworkz.repository;

import com.xworkz.entity.ReadDataEntity;

import java.util.List;

public interface ReadDataRepository {

    List<ReadDataEntity> readFromDataBase();
}
