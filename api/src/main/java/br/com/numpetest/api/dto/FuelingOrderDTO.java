package br.com.numpetest.api.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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
    @PositiveOrZero(message = "A quilometragem do veículo deve ser positiva.")
    private Integer vehicleMileage;

    @Getter
    @Setter
    @Size(min = 7, max = 8, message = "A placa do veículo deve ter entre 7 e 8 caracteres.")
    private String vehiclePlate;

    @Getter
    @Setter
    @PositiveOrZero(message = "O valor do abastecimento deve ser positivo.")
    private BigDecimal price;

    @Getter
    @Setter
    @PastOrPresent(message = "A data do abastecimento deve ser presente ou retroativa.")
    private Calendar timestamp;
}
