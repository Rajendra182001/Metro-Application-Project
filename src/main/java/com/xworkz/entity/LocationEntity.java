package com.xworkz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "location")
@NamedQuery(name = "findByTrainNumber", query = "SELECT t FROM  LocationEntity t WHERE t.trainNumber = :trainNumber")
@NamedQuery(name = "readLocation", query = "Select entities from LocationEntity entities")
@NamedQuery(name="findTrainType",query = "SELECT t FROM LocationEntity t WHERE  t.trainType = :trainType")

public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;
    private String trainNumber;
    private String trainType;
    private String locationsName;
    @ManyToOne
   // @JoinColumn(name = "addTrainId",referencedColumnName = "addTrainId")
    private AddTrainEntity addTrain;



    @Override
    public String toString() {
        return "LocationEntity{" +
                "locationId=" + locationId +
                ", trainNumber='" + trainNumber + '\'' +
                ", trainType='" + trainType + '\'' +
                ", locationsName='" + locationsName + '\'' +
                ", addTrain=" + (addTrain!=null?addTrain.getTrainType():"Train not found") +
                ", timing=" +  +
                '}';
    }
}



