package pl.slaszu.gpw.datacenter.infrastructure.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import pl.slaszu.gpw.datacenter.application.ListStockPrice.StockPriceViewModel;
import pl.slaszu.gpw.datacenter.application.ListStockPrice.StockPriceViewModelRepositoryInterface;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class StockPriceViewModelRepository implements StockPriceViewModelRepositoryInterface {

    @Autowired
    private JpaStockPriceRepository jpaStockPriceRepository;

    @Override
    public List<StockPriceViewModel> getAllByStockCode(String code) {

        return this.jpaStockPriceRepository
            .findAllByStockCode(code,
                PageRequest.of(0, 90, Sort.Direction.DESC, "date")
            )
            .stream().map(StockPriceViewModel::fromStockPrice)
            .toList();

    }

    @Override
    public List<StockPriceViewModel> getAllByStockCodeAndDateFrom(String code, Date dateFrom) {
        return this.jpaStockPriceRepository
            .findAllByStockCodeAndDateGreaterThanEqual(code, dateFrom,
                PageRequest.of(0, 90, Sort.Direction.DESC, "date")
            )
            .stream().map(StockPriceViewModel::fromStockPrice)
            .toList();
    }

}
