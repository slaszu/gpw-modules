package pl.slaszu.gpw.dataprovider.stocksource.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StockFetchedEvent {
    private StockDto stockDTO;
}
