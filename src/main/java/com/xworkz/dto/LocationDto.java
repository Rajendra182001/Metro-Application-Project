package com.xworkz.dto;

import com.xworkz.entity.AddTrainEntity;
import com.xworkz.entity.TimingEntity;
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
public class LocationDto {


    private Integer locationId;
    private String trainNumber;
    @NotEmpty(message = "trainType must not be empty")
    @NotNull(message = "trainType must not be null")
    @NotBlank(message = "trainType must not be blank")
    private String trainType;
    @NotEmpty(message = "locations must not be empty")
    @NotNull (message = "locations must not be null")
    @NotBlank (message = "locations must not be blank")
    private String locations;
    private AddTrainDto addTrainDto;

}
