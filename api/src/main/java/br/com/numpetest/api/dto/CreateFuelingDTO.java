package br.com.numpetest.api.dto;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

public class CreateFuelingDTO {

    @Getter
    @Setter
    private Double vehicleMileage;

    @Getter
    @Setter
    private String vehiclePlate;

    @Getter
    @Setter
    private Double value;

    @Getter
    @Setter
    private Calendar timestamp;
}
