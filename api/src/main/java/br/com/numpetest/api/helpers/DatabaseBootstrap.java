package br.com.numpetest.api.helpers;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.numpetest.api.dto.CreateFuelingOrderDTO;
import br.com.numpetest.api.services.FuelingOrderService;

@Component
public class DatabaseBootstrap {

    @Autowired
    private FuelingOrderService service;

    public void bootstrapFuelingOrders() {
        var dto1 = new CreateFuelingOrderDTO(200000, "ABC-1234", new BigDecimal(49.90), Calendar.getInstance());
        var dto2 = new CreateFuelingOrderDTO(200000, "ABC-1234", new BigDecimal(49.90), Calendar.getInstance());
        var dto3 = new CreateFuelingOrderDTO(200000, "ABC-1234", new BigDecimal(49.90), Calendar.getInstance());
        var dto4 = new CreateFuelingOrderDTO(200000, "CBA-4321", new BigDecimal(49.90), Calendar.getInstance());
        var dto5 = new CreateFuelingOrderDTO(200000, "CBA-4321", new BigDecimal(49.90), Calendar.getInstance());
        var dto6 = new CreateFuelingOrderDTO(200000, "CBA-4321", new BigDecimal(49.90), Calendar.getInstance());

        List<CreateFuelingOrderDTO> startingDTOs = List.of(dto1, dto2, dto3, dto4, dto5, dto6);

        startingDTOs.stream().forEach(dto -> {
            this.service.create(dto);
        });
    }
}
