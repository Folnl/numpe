package br.com.numpetest.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    private String vehiclePlate;

    @Getter
    @Setter
    @NonNull
    private BigDecimal price;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    @NonNull
    private Calendar timestamp;
}
