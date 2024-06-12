package pl.slaszu.gpw.datacenter.infrastructure.sql;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import pl.slaszu.gpw.datacenter.domain.model.Stock;
import pl.slaszu.gpw.datacenter.domain.model.StockPrice;

@Repository
public interface JpaStockPriceRepository extends JpaRepository<StockPrice, UUID> {
    public Optional<StockPrice> findByStockAndDate(Stock stock, Date date);

    @Query("select sp from StockPrice sp join sp.stock s where s.code = ?1 order by sp.date")
    List<StockPrice> findAllByStockCode(String stockCode);

    List<StockPrice> findAllByStockCode(String stockCode, Pageable pageable);

    List<StockPrice> findAllByStockCodeAndDateGreaterThanEqual(String stockCode, Date date, Pageable pageable);

    List<StockPrice> findAllByStockCodeAndDateLessThanEqual(String stockCode, Date date, Pageable pageable);

}
