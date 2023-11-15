package pl.slaszu.gpw.admin.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.slaszu.gpw.admin.form.DateOnly;
import pl.slaszu.gpw.admin.service.FetchStockService;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockCommand;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockPriceCommand;
import pl.slaszu.gpw.datacenter.application.CreateStock.CreateStockService;
import pl.slaszu.gpw.dataprovider.application.FetchData.FetchDataService;
import pl.slaszu.gpw.dataprovider.domain.dto.StockDto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FetchDateOnlyController {

    @Autowired
    private FetchStockService fetchStockService;

    @GetMapping("/admin/fetch")
    public String fetch(Model model) {
        model.addAttribute("dateOnly", new DateOnly());
        return "admin/fetch_form";
    }

    @SneakyThrows
    @PostMapping("/admin/fetch")
    public String fetchAction(@ModelAttribute DateOnly date, Model model) {

        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date.getDate().toString());

        this.fetchStockService.getAndSave(d);

        model.addAttribute("dateOnly", date);
        return "admin/fetch_result";
    }


}
