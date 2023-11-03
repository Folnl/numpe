package br.com.numpetest.api.domain;

import java.io.Serializable;
import java.util.Calendar;

import br.com.numpetest.api.dto.CreateFuelingOrderDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abastecimentos")
@NoArgsConstructor
@RequiredArgsConstructor
public class FuelingOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    @Setter
    @NonNull
    private Float vehicleMileage;

    @Getter
    @Setter
    @NonNull
    private String vehiclePlate;

    @Getter
    @Setter
    @NonNull
    private Float price;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    @NonNull
    private Calendar timestamp;

    public static FuelingOrder fromCreateDto(CreateFuelingOrderDTO createDto) {
        return new FuelingOrder(createDto.getVehicleMileage(), createDto.getVehiclePlate(), createDto.getPrice(),
                createDto.getTimestamp());
    }
}
