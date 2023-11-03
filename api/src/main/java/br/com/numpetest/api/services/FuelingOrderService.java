package br.com.numpetest.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.numpetest.api.domain.FuelingOrder;
import br.com.numpetest.api.dto.CreateFuelingOrderDTO;
import br.com.numpetest.api.dto.FuelingOrderDTO;
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
        return mapper.toDTO(domain.orElseThrow());
    }

    @Transactional
    public FuelingOrderDTO create(CreateFuelingOrderDTO createDTO) {
        var domain = repository.save(mapper.toDomain(createDTO));
        return mapper.toDTO(domain);
    }
}
