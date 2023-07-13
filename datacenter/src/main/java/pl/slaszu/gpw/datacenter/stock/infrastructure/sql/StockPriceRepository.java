package pl.slaszu.gpw.datacenter.stock.infrastructure.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.slaszu.gpw.datacenter.stock.domain.model.Stock;
import pl.slaszu.gpw.datacenter.stock.domain.model.StockPrice;
import pl.slaszu.gpw.datacenter.stock.domain.repository.StockPriceRepositoryInterface;

import java.util.Date;
import java.util.Optional;

@Repository
public class StockPriceRepository implements StockPriceRepositoryInterface {

    @Autowired
    private JpaStockPriceRepository jpaStockPriceRepository;

    @Override
    public Optional<StockPrice> getByStockAndDate(Stock stock, Date date) {
        return this.jpaStockPriceRepository.findByStockAndDate(stock, date);
    }

    @Override
    public StockPrice save(StockPrice stockPrice) {
        return this.jpaStockPriceRepository.save(stockPrice);
    }
}
