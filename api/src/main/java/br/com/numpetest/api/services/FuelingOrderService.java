package br.com.numpetest.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.numpetest.api.domain.FuelingOrder;
import br.com.numpetest.api.dto.CreateFuelingOrderDTO;
import br.com.numpetest.api.dto.FuelingOrderDTO;
import br.com.numpetest.api.exceptions.NoSuchElementFoundException;
import br.com.numpetest.api.exceptions.ResponseException;
import br.com.numpetest.api.mappers.FuelingOrderMapper;
import br.com.numpetest.api.repositories.FuelingOrderRepository;
import jakarta.transaction.Transactional;

@Service
public class FuelingOrderService {

    @Autowired
    private FuelingOrderRepository repository;

    @Autowired
    private FuelingOrderMapper mapper;

    public List<FuelingOrderDTO> list() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public FuelingOrderDTO findById(Long id) {
        var domain = repository.findById(id);
        return mapper.toDTO(domain
                .orElseThrow(() -> new NoSuchElementFoundException("Nenhum abastecimento encontrado com ID: " + id)));
    }

    @Transactional
    public FuelingOrderDTO create(CreateFuelingOrderDTO createDTO) {
        var domainToSave = mapper.toDomain(createDTO);
        Boolean isValidDomain = isMileageBiggerThanPreviousFueling(domainToSave);

        if (isValidDomain) {
            var domain = repository.save(domainToSave);
            return mapper.toDTO(domain);
        } else {
            throw new ResponseException(HttpStatus.BAD_REQUEST,
                    "Registro com data/hora e quilometragem em desacordo com o histórico.");
        }
    }

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private Boolean isMileageBiggerThanPreviousFueling(FuelingOrder newDomain) {
        List<FuelingOrder> foundDomains = this.repository
                .findByVehiclePlateOrderByTimestampDesc(newDomain.getVehiclePlate());

        if (foundDomains.isEmpty()) {
            return true;
        }

        for (FuelingOrder foundDomain : foundDomains) {
            if (foundDomain.getTimestamp().before(newDomain.getTimestamp())) {
                if (newDomain.getVehicleMileage() >= foundDomain.getVehicleMileage()) {
                    return true;
                }

                return false;
            } else {
                if (newDomain.getVehicleMileage() <= foundDomain.getVehicleMileage()) {
                    return true;
                }
            }
        }

        return false;
    }
}
