package pl.slaszu.gpw.datacenter.application.ListStockPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ListStockPriceService {

    @Autowired
    private StockPriceViewModelRepositoryInterface stockPriceViewModelRepository;

    public List<StockPriceViewModel> getAllByStockCode(String code) {
        return this.stockPriceViewModelRepository.getAllByStockCode(code);
    }

    public List<StockPriceViewModel> getAllByStockCodeAndDateFrom(String code, Date dateFrom) {
        return this.stockPriceViewModelRepository.getAllByStockCodeAndDateFrom(code, dateFrom);
    }

    public List<StockPriceViewModel> getLastByStockCodeAndDateTo(String code, Date dateTo) {
        return this.stockPriceViewModelRepository.getLastByStockCodeAndDateTo(code, dateTo);
    }
}
