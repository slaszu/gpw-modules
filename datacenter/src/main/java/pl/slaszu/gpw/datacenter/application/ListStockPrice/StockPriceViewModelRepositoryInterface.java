package pl.slaszu.gpw.datacenter.application.ListStockPrice;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface StockPriceViewModelRepositoryInterface {

    public List<StockPriceViewModel> getAllByStockCode(String code);

    public List<StockPriceViewModel> getAllByStockCodeAndDateFrom(
        String code,
        Date dateFrom
    );
}
