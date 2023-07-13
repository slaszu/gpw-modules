package pl.slaszu.gpw.datacenter.stock.infrastructure.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import pl.slaszu.gpw.datacenter.stock.application.ListStockPrice.StockPriceViewModel;
import pl.slaszu.gpw.datacenter.stock.application.ListStockPrice.StockPriceViewModelRepositoryInterface;

import java.util.List;

@Repository
public class StockPriceViewModelRepository implements StockPriceViewModelRepositoryInterface {

    @Autowired
    private JpaStockPriceRepository jpaStockPriceRepository;

    @Override
    public List<StockPriceViewModel> getAllByStockCode(String code) {

        // TODO: 20.04.2023 sortowanie po dacie asc, desc i limit podawany w parametrze endpointu
        return this.jpaStockPriceRepository
            .findAllByStockCode(code, PageRequest.of(0, 90, Sort.Direction.DESC, "date"))
            .stream().map(StockPriceViewModel::fromStockPrice)
            .toList();

    }
}
