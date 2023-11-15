package pl.slaszu.gpw.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockCommand;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockPriceCommand;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockService;
import pl.slaszu.gpw.dataprovider.application.FetchData.FetchDataService;
import pl.slaszu.gpw.dataprovider.domain.dto.StockDto;

import java.util.Date;
import java.util.List;

@Service
public class FetchStockService {


    @Autowired
    private FetchDataService fetchDataService;

    @Autowired
    private CreateStockService createStockService;

    @Async
    public void getAndSave(Date date) {
        List<StockDto> stockDtoList = this.fetchDataService.getStockByDate(date);
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
    }
}
