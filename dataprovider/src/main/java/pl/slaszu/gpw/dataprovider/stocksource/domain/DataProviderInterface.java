package pl.slaszu.gpw.dataprovider.stocksource.domain;

import pl.slaszu.gpw.restapi.stocksource.domain.exception.FetchStocksException;

import java.util.Date;
import java.util.List;

public interface DataProviderInterface {
    public List<StockDto> getData(Date date) throws FetchStocksException;
}
