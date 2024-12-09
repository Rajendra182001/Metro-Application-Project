package com.xworkz.dto;

import com.xworkz.entity.AddTrainEntity;
import com.xworkz.entity.LocationEntity;
import com.xworkz.entity.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimingDto {

    private Integer timingId;
    private String trainType;
    private String trainNumber;
    private String fromTime;
     private String toTime;
     private String source;
     private String destination;
    private String dayOfTheWeek;
    private AddTrainDto addTrainDto;

}
