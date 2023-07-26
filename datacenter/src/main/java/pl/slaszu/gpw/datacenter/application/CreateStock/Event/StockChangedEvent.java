package pl.slaszu.gpw.datacenter.application.CreateStock.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.slaszu.gpw.datacenter.domain.model.Stock;


@AllArgsConstructor
@Getter
public class StockChangedEvent {
    private Stock stock;
}
