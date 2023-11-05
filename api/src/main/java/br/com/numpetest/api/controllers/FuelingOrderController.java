package br.com.numpetest.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.numpetest.api.dto.CreateFuelingOrderDTO;
import br.com.numpetest.api.dto.FuelingOrderDTO;
import br.com.numpetest.api.helpers.SuccessResponse;
import br.com.numpetest.api.services.FuelingOrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fueling_orders")
@CrossOrigin
@Validated
public class FuelingOrderController {

    @Autowired
    private FuelingOrderService service;

    @GetMapping
    public SuccessResponse<List<FuelingOrderDTO>> list() {
        var dtos = service.list();
        return new SuccessResponse<>(HttpStatus.OK, dtos);
    }

    @PostMapping
    public SuccessResponse<FuelingOrderDTO> create(@RequestBody() @Valid CreateFuelingOrderDTO createDTO) {
        var dto = service.create(createDTO);
        return new SuccessResponse<FuelingOrderDTO>(HttpStatus.CREATED, dto);
    }

    @DeleteMapping("{id}")
    public SuccessResponse<String> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new SuccessResponse<String>(HttpStatus.ACCEPTED, null);
    }
}
