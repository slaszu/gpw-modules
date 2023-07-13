package pl.slaszu.gpw.datacenter.stock.infrastructure.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.slaszu.gpw.datacenter.stock.application.ListStocks.StockViewModel;
import pl.slaszu.gpw.datacenter.stock.application.ListStocks.StockViewModelRepositoryInterface;
import pl.slaszu.gpw.datacenter.stock.domain.model.Stock;

import java.util.List;

@Repository
public class StockVewModelRepository implements StockViewModelRepositoryInterface {
    @Autowired
    private JpaStockRepository jpaStockRepository;

    @Override
    public List<StockViewModel> getAll() {
        List<Stock> stockList = this.jpaStockRepository.findAll();

        return this.convertStockToStockViewModel(stockList);
    }

    @Override
    public List<StockViewModel> getAllLike(String query) {
        List<Stock> stockList = this.jpaStockRepository.findAll(query);

        return this.convertStockToStockViewModel(stockList);
    }

    private List<StockViewModel> convertStockToStockViewModel(List<Stock> stockList) {
        return stockList.stream().map(stock ->
            new StockViewModel(
                stock.getName(),
                stock.getCode()
            )
        ).toList();
    }
}
