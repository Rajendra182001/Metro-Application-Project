package com.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocDto {

    private Integer addTrainId;
    private String trainNumber;
    private String trainType;
    private PriceDto priceEntity;
    private   LocationDto locations;
    private TimingDto timingEntity;

}
