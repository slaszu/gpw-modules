package pl.slaszu.gpw.restapi.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockCommand;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockPriceCommand;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockService;
import pl.slaszu.gpw.dataprovider.application.FetchData.FetchDataService;
import pl.slaszu.gpw.dataprovider.domain.dto.StockDto;

import java.util.Date;
import java.util.List;

@Component
public class GetStockTask {

    @Autowired
    private FetchDataService fetchDataService;

    @Autowired
    private CreateStockService createStockService;

    /*
      @see https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronExpression.html
     * in cron statement is 6 digits
     */
    @Scheduled(cron = "0 */15 9-17 * * 1-5")
    public void getCurrentStock() {
        Date date = new Date();

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
