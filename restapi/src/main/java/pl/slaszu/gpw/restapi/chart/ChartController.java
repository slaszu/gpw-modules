package pl.slaszu.gpw.restapi.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "core")
public class ChartController {

    @Autowired
    private ChartGenerator chartGenerator;

    @GetMapping({"/chart/{code}/{lastDaysQty}", "/chart/{code}"})
    @Operation(summary = "get chart as base64 png")
    public String getChartForStockCode(
        @PathVariable String code,
        @PathVariable(required = false) Integer lastDaysQty
    ) throws IOException {
        if (lastDaysQty == null) {
            lastDaysQty = 30;
        }

        return this.chartGenerator.generate(code, lastDaysQty);

    }
}
