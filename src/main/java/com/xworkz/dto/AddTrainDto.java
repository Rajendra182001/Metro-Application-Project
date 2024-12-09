package com.xworkz.dto;

import com.xworkz.entity.LocationEntity;
import com.xworkz.entity.PriceEntity;
import com.xworkz.entity.TimingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTrainDto {

    private Integer addTrainId;
    private String trainNumber;
    @NotEmpty(message = "trainType must not be empty")
    @NotNull(message = "trainType must not be null")
    @NotBlank(message = "trainType must not be blank")
    private String trainType;

  private   List<PriceDto> priceEntity;

  private   List<LocationDto> locations;
   private List<TimingDto> timingEntity;


}
