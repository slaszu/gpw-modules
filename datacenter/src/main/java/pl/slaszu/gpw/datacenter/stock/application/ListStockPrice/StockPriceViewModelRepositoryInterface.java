package pl.slaszu.gpw.datacenter.stock.application.ListStockPrice;

import java.util.List;

public interface StockPriceViewModelRepositoryInterface {

    public List<StockPriceViewModel> getAllByStockCode(String code);
}
