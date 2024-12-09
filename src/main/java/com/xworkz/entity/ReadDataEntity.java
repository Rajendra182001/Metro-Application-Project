package com.xworkz.entity;

import com.xworkz.dto.AddTrainDto;
import com.xworkz.dto.LocationDto;
import com.xworkz.dto.PriceDto;
import com.xworkz.dto.TimingDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "readData")
public class ReadDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String trainNumber;
    private String trainType;
    private String locations;
    private String fromTime;
    private String toTime;
    private String source;
    private String destination;
    private String dayOfTheWeek;
    private Integer price;
}
