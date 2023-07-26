package pl.slaszu.gpw.dataprovider.application.FetchData;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.slaszu.gpw.dataprovider.domain.dto.StockDto;
import pl.slaszu.gpw.dataprovider.domain.exception.FetchStocksException;
import pl.slaszu.gpw.dataprovider.infrastructure.gpwpl.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FetchDataService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private DataProvider gpwplDataProvider;

    public List<StockDto> getStockByDate(Date date) {

        log.info("Scheduler {}", dateFormat.format(date));
        try {
            return this.gpwplDataProvider.getData(date);
        } catch (FetchStocksException e) {
            log.info("FetchStocksException: %s".formatted(e.getMessage()));
        }
        return null;
    }
}
