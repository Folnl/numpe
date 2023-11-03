package br.com.numpetest.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.numpetest.api.dto.FuelingOrderDTO;
import br.com.numpetest.api.helpers.SuccessResponse;
import br.com.numpetest.api.services.FuelingOrderService;

@RestController
@RequestMapping("/fueling_orders")
@Validated
public class FuelingOrderController {

    @Autowired
    private FuelingOrderService service;

    @GetMapping
    public SuccessResponse<List<FuelingOrderDTO>> list() {
        var dtos = service.list();
        return new SuccessResponse<>(HttpStatus.OK, dtos);
    }

    @GetMapping("{id}")
    public SuccessResponse<FuelingOrderDTO> findById(
            @PathVariable("id") Long id) {
        var dto = service.findById(id);
        return new SuccessResponse<>(HttpStatus.OK, dto);
    }
}
