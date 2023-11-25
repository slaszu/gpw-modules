package pl.slaszu.gpw.datacenter.application.CreateStock.Event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.slaszu.gpw.datacenter.application.ListStockPrice.ListStockPriceService;

@Component
@Slf4j
public class DataChangedListener {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private ListStockPriceService listStockPriceService;

    @EventListener
    @Async
    public void whenStockChanged(StockChangedEvent event) {
        Cache stockCache = this.cacheManager.getCache("stock");
        if (stockCache == null) {
            return;
        }

        stockCache.clear();
        log.debug("Cache for stock cleared");
    }

    @EventListener
    @Async
    public void whenStockPriceChanged(StockPriceChangedEvent event) {
        Cache stockPriceCache = this.cacheManager.getCache("stock_price");
        if (stockPriceCache == null) {
            return;
        }

        String code = event.getStockPrice().getStock().getCode();
        if (code == null) {
            return;
        }
        stockPriceCache.evictIfPresent(code.toLowerCase());
        log.debug("Cache for stock_price:%s cleared".formatted(code));

        this.listStockPriceService.getAllByStockCode(code);
        log.debug("Cache for stock_price:%s created".formatted(code));

    }
}
