package br.com.numpetest.api.dto;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

public class CreateFuelingOrderDTO {

    @Getter
    @Setter
    private Float vehicleMileage;

    @Getter
    @Setter
    private String vehiclePlate;

    @Getter
    @Setter
    private Float price;

    @Getter
    @Setter
    private Calendar timestamp;
}
