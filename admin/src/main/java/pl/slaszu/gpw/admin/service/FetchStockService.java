package pl.slaszu.gpw.admin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockCommand;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockPriceCommand;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockService;
import pl.slaszu.gpw.dataprovider.application.FetchData.FetchDataService;
import pl.slaszu.gpw.dataprovider.domain.dto.StockDto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FetchStockService {


    @Autowired
    private FetchDataService fetchDataService;

    @Autowired
    private CreateStockService createStockService;

    @Async
    public void getAndSave(Date date) {
        List<StockDto> stockDtoList = this.fetchDataService.getStockByDate(date);
        if (stockDtoList == null) {
            return;
        }
        stockDtoList.forEach(stockDTO -> {
            CreateStockPriceCommand stockPriceCommand = new CreateStockPriceCommand(
                stockDTO.getPriceOpen(),
                stockDTO.getPriceHigh(),
                stockDTO.getPriceLow(),
                stockDTO.getPrice(),
                stockDTO.getVolume(),
                stockDTO.getAmount(),
                stockDTO.getDate()
            );

            CreateStockCommand command = new CreateStockCommand(stockDTO.getCode(), stockDTO.getName(), stockPriceCommand);

            this.createStockService.create(command);
        });

        log.info("Stock fetched and saved for date %s".formatted(date.toString()));
    }

    @Async
    public void getAndSave(Date dateFrom, Date dateTo) {
        Calendar start = Calendar.getInstance();
        start.setTime(dateFrom);
        Calendar end = Calendar.getInstance();
        end.setTime(dateTo);

        for (Date date = start.getTime(); start.before(end) || start.equals(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            this.getAndSave(date);
        }
    }
}
