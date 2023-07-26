package pl.slaszu.gpw.dataprovider.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.slaszu.gpw.dataprovider.domain.exception.FetchStocksException;

import java.util.Date;

@Service
@Slf4j
public class FetchStocksService {

    public void fetch(DataProviderInterface dataProviderInterface, Date date) throws FetchStocksException {
        dataProviderInterface.getData(date);
        // TODO: 14.07.2023 fire events to create stocks data
//        .forEach(
//            (StockDto stockDTO) -> {
//                this.eventDispatcher.dispatch(new StockFetchedEvent(stockDTO));
//            }
//        );
    }
}
