package pl.slaszu.gpw.datacenter.application.ListStockPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListStockPriceService {

    @Autowired
    private StockPriceViewModelRepositoryInterface stockPriceViewModelRepository;

    @Cacheable(value = "stock_price", key = "#code.toLowerCase()")
    public List<StockPriceViewModel> getAllByStockCode(String code) {
        return this.stockPriceViewModelRepository.getAllByStockCode(code);
    }

    public List<StockPriceViewModel> getAllByStockCode(String code, Integer lastDaysQty) {
        return this.getAllByStockCode(code).stream().limit(lastDaysQty).toList();
    }
}
