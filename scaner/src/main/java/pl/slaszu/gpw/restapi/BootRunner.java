package pl.slaszu.gpw.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import pl.slaszu.gpw.datacenter.application.ListStockPrice.ListStockPriceService;
import pl.slaszu.gpw.datacenter.application.ListStockPrice.StockPriceViewModel;
import pl.slaszu.gpw.dataprovider.application.FetchData.FetchDataService;

@Component
public class BootRunner implements ApplicationRunner {

    @Autowired
    private FetchDataService fetchDataService;

    @Autowired
    private ListStockPriceService listStockPriceService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(">>> Aplikacja wystartowała!...");

        List<StockPriceViewModel> result = this.listStockPriceService.getAllByStockCode("PZU");

        System.out.println(">>> Najnowsze dane dla PZU z bazy danych to:...");

        System.out.println(result.getFirst().toString());

    }
}
