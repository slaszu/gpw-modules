package pl.slaszu.gpw.restapi.chart;

import lombok.*;

@Getter
@AllArgsConstructor
public class ChartModel {
    private String code;
    private String pngBase64;
}
