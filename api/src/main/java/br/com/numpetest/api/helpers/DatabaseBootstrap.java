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

        var dto1 = new CreateFuelingOrderDTO(200000, "ABC-1234", new BigDecimal(49.90), getCalendarPlusDays(1));
        var dto2 = new CreateFuelingOrderDTO(200000, "ABC-1234", new BigDecimal(49.90), getCalendarPlusDays(2));
        var dto3 = new CreateFuelingOrderDTO(200000, "ABC-1234", new BigDecimal(49.90), getCalendarPlusDays(3));
        var dto4 = new CreateFuelingOrderDTO(200000, "CBA-4321", new BigDecimal(49.90), getCalendarPlusDays(4));
        var dto5 = new CreateFuelingOrderDTO(200000, "CBA-4321", new BigDecimal(49.90), getCalendarPlusDays(5));
        var dto6 = new CreateFuelingOrderDTO(200000, "CBA-4321", new BigDecimal(49.90), getCalendarPlusDays(6));

        List<CreateFuelingOrderDTO> startingDTOs = List.of(dto1, dto2, dto3, dto4, dto5, dto6);

        startingDTOs.stream().forEach(dto -> {
            this.service.create(dto);
        });
    }

    private Calendar getCalendarPlusDays(Integer days) {
        var calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);

        return calendar;
    }
}
