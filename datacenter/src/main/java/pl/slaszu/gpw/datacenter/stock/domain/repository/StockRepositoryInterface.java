package pl.slaszu.gpw.datacenter.stock.domain.repository;


import pl.slaszu.gpw.datacenter.stock.domain.model.Stock;

import java.util.Optional;
import java.util.UUID;

public interface StockRepositoryInterface {
    public Optional<Stock> getById(UUID stockId);

    public Optional<Stock> getByCode(String code);

    public Optional<Stock> getByName(String code);

    public Stock save(Stock stock);
}
