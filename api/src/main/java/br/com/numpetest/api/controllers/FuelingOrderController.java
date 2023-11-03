package br.com.numpetest.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.numpetest.api.dto.FuelingOrderDTO;
import br.com.numpetest.api.services.FuelingOrderService;

@RestController
@RequestMapping("/fueling_orders")
public class FuelingOrderController {

    @Autowired
    private FuelingOrderService service;

    @GetMapping
    public ResponseEntity<List<FuelingOrderDTO>> list() {
        var dtos = service.list();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<FuelingOrderDTO> findById(@PathVariable("id") Long id) {
        var dto = service.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
