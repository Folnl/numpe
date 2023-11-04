package br.com.numpetest.api.dto;

import java.math.BigDecimal;
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
    private Integer vehicleMileage;

    @Getter
    @Setter
    private String vehiclePlate;

    @Getter
    @Setter
    private BigDecimal price;

    @Getter
    @Setter
    private Calendar timestamp;
}
