package br.com.numpetest.api.mappers;

import org.springframework.stereotype.Component;

import br.com.numpetest.api.domain.FuelingOrder;
import br.com.numpetest.api.dto.CreateFuelingOrderDTO;
import br.com.numpetest.api.dto.FuelingOrderDTO;

@Component
public class FuelingOrderMapper {

    public FuelingOrder toDomain(FuelingOrderDTO dto) {
        return new FuelingOrder(dto.getId(), dto.getVehicleMileage(), dto.getVehiclePlate(), dto.getPrice(),
                dto.getTimestamp());
    }

    public FuelingOrder toDomain(CreateFuelingOrderDTO dto) {
        return new FuelingOrder(dto.getVehicleMileage(), dto.getVehiclePlate(), dto.getPrice(),
                dto.getTimestamp());
    }

    public FuelingOrderDTO toDTO(FuelingOrder domain) {
        return new FuelingOrderDTO(domain.getId(), domain.getVehicleMileage(), domain.getVehiclePlate(),
                domain.getPrice(), domain.getTimestamp());
    }
}
