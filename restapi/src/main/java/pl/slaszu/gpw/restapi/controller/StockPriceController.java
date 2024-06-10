package pl.slaszu.gpw.restapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.slaszu.gpw.datacenter.application.ListStockPrice.ListStockPriceService;
import pl.slaszu.gpw.datacenter.application.ListStockPrice.StockPriceViewModel;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stocks/prices")
@Tag(name = "core")
public class StockPriceController {

    @Autowired
    private ListStockPriceService listStockPriceService;

    @GetMapping("/{stockCode}")
    @Operation(summary = "get last 90 stock prices for stock code")
    public List<StockPriceViewModel> getAllByStockCode(
        @PathVariable String stockCode
    ) {
        return this.listStockPriceService.getAllByStockCode(stockCode);
    }

    @GetMapping("/{stockCode}/{dateFrom}")
    public List<StockPriceViewModel> getAllByStockCodeAndDateFrom(
        @PathVariable String stockCode,
        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom
    ) {
        return this.listStockPriceService.getAllByStockCodeAndDateFrom(stockCode, dateFrom);
    }
}
