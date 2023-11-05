package br.com.numpetest.api.helpers;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
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

        var dto1 = new CreateFuelingOrderDTO(200000, "AAA1234", new BigDecimal(49.90), getDatePlusDays(1));
        var dto2 = new CreateFuelingOrderDTO(200000, "AAA1234", new BigDecimal(49.90), getDatePlusDays(2));
        var dto3 = new CreateFuelingOrderDTO(200000, "AAA1234", new BigDecimal(49.90), getDatePlusDays(3));
        var dto4 = new CreateFuelingOrderDTO(200000, "BBB4321", new BigDecimal(49.90), getDatePlusDays(4));
        var dto5 = new CreateFuelingOrderDTO(200000, "BBB4321", new BigDecimal(49.90), getDatePlusDays(5));
        var dto6 = new CreateFuelingOrderDTO(200000, "BBB4321", new BigDecimal(49.90), getDatePlusDays(6));

        List<CreateFuelingOrderDTO> startingDTOs = List.of(dto1, dto2, dto3, dto4,
                dto5, dto6);

        startingDTOs.stream().forEach(dto -> {
            this.service.create(dto);
        });
    }

    private Date getDatePlusDays(Integer days) {
        var calendar = Calendar.getInstance();
        calendar.set(2021, 10, 1);
        calendar.add(Calendar.DATE, days);

        return calendar.getTime();
    }
}
