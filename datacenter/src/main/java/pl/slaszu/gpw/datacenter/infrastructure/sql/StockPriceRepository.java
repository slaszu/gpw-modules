package pl.slaszu.gpw.datacenter.infrastructure.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.slaszu.gpw.datacenter.domain.model.StockPrice;
import pl.slaszu.gpw.datacenter.domain.repository.StockPriceRepositoryInterface;
import pl.slaszu.gpw.datacenter.domain.model.Stock;

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
