package br.com.numpetest.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abastecimentos")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class FuelingOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    @Setter
    @NonNull
    private Integer vehicleMileage;

    @Getter
    @Setter
    @NonNull
    @NotBlank
    @Size(min = 7, max = 8, message = "A placa do veículo deve ter entre 7 e 8 caracteres.")
    private String vehiclePlate;

    @Getter
    @Setter
    @NonNull
    @PositiveOrZero(message = "O valor do abastecimento deve ser positivo.")
    private BigDecimal price;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    @NonNull
    @PastOrPresent(message = "A data do abastecimento deve ser presente ou retroativa.")
    private Date timestamp;
}
