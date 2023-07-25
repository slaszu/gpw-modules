package pl.slaszu.gpw.datacenter.application.ListStockPrice;

import java.util.List;

public interface StockPriceViewModelRepositoryInterface {

    public List<StockPriceViewModel> getAllByStockCode(String code);
}
