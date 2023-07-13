package pl.slaszu.gpw.dataprovider.stocksource.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.slaszu.gpw.restapi.sharedkernel.domain.EventDispatcherInterface;
import pl.slaszu.gpw.restapi.stock.application.CreateStock.CreateStockService;
import pl.slaszu.gpw.restapi.stocksource.domain.exception.FetchStocksException;

import java.util.Date;

@Service
@Slf4j
public class FetchStocksService {

    @Autowired
    private CreateStockService createStockService;

    @Autowired
    private EventDispatcherInterface eventDispatcher;

    public void fetch(DataProviderInterface dataProviderInterface, Date date) throws FetchStocksException {
        dataProviderInterface.getData(date).forEach(
            (StockDto stockDTO) -> {
                this.eventDispatcher.dispatch(new StockFetchedEvent(stockDTO));
            }
        );
    }
}
