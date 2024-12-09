package com.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReadDataDto {
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
