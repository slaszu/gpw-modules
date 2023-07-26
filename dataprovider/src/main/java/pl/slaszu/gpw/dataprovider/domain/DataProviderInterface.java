package pl.slaszu.gpw.dataprovider.domain;

import pl.slaszu.gpw.dataprovider.domain.dto.StockDto;
import pl.slaszu.gpw.dataprovider.domain.exception.FetchStocksException;

import java.util.Date;
import java.util.List;

public interface DataProviderInterface {
    public List<StockDto> getData(Date date) throws FetchStocksException;
}
