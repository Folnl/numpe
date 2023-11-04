package br.com.numpetest.api.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CreateFuelingOrderDTO {

    @Getter
    @Setter
    private Integer vehicleMileage;

    @Getter
    @Setter
    @Size(min = 7, max = 8, message = "A placa do veículo deve ter entre 7 e 8 caracteres.")
    private String vehiclePlate;

    @Getter
    @Setter
    @Positive(message = "O valor do abastecimento deve ser positivo.")
    private BigDecimal price;

    @Getter
    @Setter
    private Calendar timestamp;
}
