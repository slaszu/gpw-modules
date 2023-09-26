package pl.slaszu.gpw.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.slaszu.gpw.datacenter.application.ListStockPrice.ListStockPriceService;
import pl.slaszu.gpw.datacenter.application.ListStockPrice.StockPriceViewModel;
import pl.slaszu.gpw.datacenter.application.ListStocks.ListStocksService;
import pl.slaszu.gpw.datacenter.application.ListStocks.StockViewModel;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ListStocksService listStocksService;

    @Autowired
    private ListStockPriceService listStockPriceService;

    @GetMapping("/admin")
    public String index(Model model) {


        return "admin/home";
    }

    @GetMapping("/admin/stocks")
    public String stocks(Model model) {

        List<StockViewModel> allStocks = this.listStocksService.getAllStocks();

        model.addAttribute("allStocks", allStocks);
        return "admin/stocks";
    }

    @GetMapping("/admin/stock_prices/{stockCode}")
    public String stockPrices(Model model, @PathVariable("stockCode") String stockCode) {

        List<StockPriceViewModel> allByStockCode = this.listStockPriceService.getAllByStockCode(stockCode);

        model.addAttribute("stockCode", stockCode);
        model.addAttribute("allStockPrices", allByStockCode);
        return "admin/stock_prices";
    }
}
