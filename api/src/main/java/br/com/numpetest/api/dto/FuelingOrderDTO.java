package br.com.numpetest.api.dto;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class FuelingOrderDTO {

    @Getter
    @Setter
    private Long id;

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
