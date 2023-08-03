package pl.slaszu.gpw.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("date", LocalDate.now().toString());
        return "admin/home";
    }
}
