package pl.slaszu.gpw.datacenter.application.ListStocks;

import java.util.List;

public interface StockViewModelRepositoryInterface {

    public List<StockViewModel> getAll();

    public List<StockViewModel> getAllLike(String like);
}
