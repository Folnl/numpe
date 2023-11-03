package br.com.numpetest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.numpetest.api.domain.FuelingOrder;
import br.com.numpetest.api.dto.CreateFuelingOrderDTO;
import br.com.numpetest.api.mappers.FuelingOrderMapper;
import br.com.numpetest.api.repositories.FuelingOrderRepository;
import jakarta.transaction.Transactional;

@Service
public class FuelingOrderService {

    @Autowired
    private FuelingOrderRepository repository;

    @Autowired
    private FuelingOrderMapper mapper;

    public List<FuelingOrder> list() {
        return repository.findAll();
    }

    public FuelingOrder findById(Long id) {
        var domain = repository.findById(id);
        return domain.orElseThrow();
    }

    @Transactional
    public FuelingOrder create(CreateFuelingOrderDTO createDTO) {
        return repository.save(mapper.toDomain(createDTO));
    }
}
