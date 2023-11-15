package pl.slaszu.gpw.admin.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DateRange {
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
