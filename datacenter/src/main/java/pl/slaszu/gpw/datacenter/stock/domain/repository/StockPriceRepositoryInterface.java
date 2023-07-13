package pl.slaszu.gpw.datacenter.stock.domain.repository;


import pl.slaszu.gpw.datacenter.stock.domain.model.Stock;
import pl.slaszu.gpw.datacenter.stock.domain.model.StockPrice;

import java.util.Date;
import java.util.Optional;

public interface StockPriceRepositoryInterface {
    public Optional<StockPrice> getByStockAndDate(Stock stock, Date date);

    public StockPrice save(StockPrice stockPrice);
}
