package br.com.numpetest.api.domain;

import java.io.Serializable;
import java.util.Calendar;

import br.com.numpetest.api.dto.CreateFuelingDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abastecimentos")
@RequiredArgsConstructor
public class Fueling implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @NonNull
    private Double vehicleMileage;

    @Getter
    @Setter
    @NonNull
    private String vehiclePlate;

    @Getter
    @Setter
    @NonNull
    private Double value;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    @NonNull
    private Calendar timestamp;

    public static Fueling fromCreateDto(CreateFuelingDTO createDto) {
        return new Fueling(createDto.getVehicleMileage(), createDto.getVehiclePlate(), createDto.getValue(),
                createDto.getTimestamp());
    }
}
