package pl.slaszu.gpw.admin.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.slaszu.gpw.admin.form.DateOnly;
import pl.slaszu.gpw.admin.form.DateRange;
import pl.slaszu.gpw.admin.service.FetchStockService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FetchDateRangeController {

    @Autowired
    private FetchStockService fetchStockService;

    @GetMapping("/admin/fetch_range")
    public String fetch(Model model) {
        model.addAttribute("dateRange", new DateRange());
        return "admin/fetch_range_form";
    }

    @SneakyThrows
    @PostMapping("/admin/fetch_range")
    public String fetchAction(@ModelAttribute DateRange date, Model model) {

        Date dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(date.getDateFrom().toString());
        Date dateTo = new SimpleDateFormat("yyyy-MM-dd").parse(date.getDateTo().toString());

        this.fetchStockService.getAndSave(dateFrom, dateTo);

        model.addAttribute("dateRange", date);
        return "admin/fetch_range_result.html";
    }


}
