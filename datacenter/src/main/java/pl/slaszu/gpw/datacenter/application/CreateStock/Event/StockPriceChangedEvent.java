package pl.slaszu.gpw.datacenter.application.CreateStock.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.slaszu.gpw.datacenter.domain.model.StockPrice;

@AllArgsConstructor
@Getter
public class StockPriceChangedEvent {
    private StockPrice stockPrice;
}
