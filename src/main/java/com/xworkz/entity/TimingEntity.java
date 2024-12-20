package com.xworkz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.xworkz.dto.ReadDataDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Data
    @Entity
@Table(name = "timings")
@NamedQuery(name = "findBYSourceAndDestination",
        query = "SELECT t FROM TimingEntity t WHERE t.source = :source AND t.destination = :destination")
@NamedQuery(name = "readTime",query="Select entities from TimingEntity entities")
@NamedQuery(name="time",query = "SELECT t FROM TimingEntity t WHERE  t.trainType = :trainType")
@NamedQuery(name = "findTrainBySourceAndDestination",
        query = "SELECT t FROM TimingEntity t WHERE t.source =:source AND t.destination = :destination")
@NamedQuery(name="timingId",query = "SELECT p FROM TimingEntity p WHERE p.timingId = :timingId")

public class TimingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timingId;
    private String trainType;
    private String fromTime;
    private String toTime;
    private String source;
    private String destination;
    private String dayOfTheWeek;

    @ManyToOne
    private AddTrainEntity addTrain;


    @Override
    public String toString() {
        return "TimingEntity{" +
                "timingId=" + timingId +
                ", trainType='" + trainType + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", addTrain=" + (addTrain!=null?addTrain.getTrainType():"Train not found") +
                '}';
    }
}
