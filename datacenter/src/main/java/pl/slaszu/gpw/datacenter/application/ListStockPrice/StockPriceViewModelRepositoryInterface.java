package pl.slaszu.gpw.datacenter.application.ListStockPrice;

import java.util.Date;
import java.util.List;

public interface StockPriceViewModelRepositoryInterface {

    List<StockPriceViewModel> getAllByStockCode(String code);

    List<StockPriceViewModel> getAllByStockCodeAndDateFrom(
        String code,
        Date dateFrom
    );

    List<StockPriceViewModel> getLastByStockCodeAndDateTo(
        String code,
        Date dateTo
    );
}
