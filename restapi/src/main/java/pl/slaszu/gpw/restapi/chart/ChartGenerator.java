package pl.slaszu.gpw.restapi.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.Timeline;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import pl.slaszu.gpw.datacenter.application.ListStockPrice.ListStockPriceService;
import pl.slaszu.gpw.datacenter.application.ListStockPrice.StockPriceViewModel;

@Service
public class ChartGenerator {

    @Autowired
    private ListStockPriceService listStockPriceService;

    public String generate(String code, Integer lastDaysQty) throws IOException {
        /*
        1. get stockPriceList
        2. prepare dataset
        3. create cart
         */

        List<StockPriceViewModel> allByStockCode = this.listStockPriceService.getAllByStockCode(code, lastDaysQty);

        int size = allByStockCode.size();

        Date[] dateArray = new Date[size];
        double[] highArray = new double[size];
        double[] lowArray = new double[size];
        double[] openArray = new double[size];
        double[] closeArray = new double[size];
        double[] volumeArray = new double[size];

        for (int i = 0; i < size; i++) {
            StockPriceViewModel s = allByStockCode.get(i);
            dateArray[i] = s.getDate();
            highArray[i] = s.getPriceHigh().doubleValue();
            lowArray[i] = s.getPriceLow().doubleValue();
            openArray[i] = s.getPriceOpen().doubleValue();
            closeArray[i] = s.getPrice().doubleValue();
            volumeArray[i] = s.getVolume().doubleValue();
        };

        DefaultHighLowDataset defaultHighLowDataset = new DefaultHighLowDataset(
            code,
            dateArray,
            highArray,
            lowArray,
            openArray,
            closeArray,
            volumeArray
        );


        JFreeChart chart = this.createChart(defaultHighLowDataset, code, dateArray);
        BufferedImage bufferedImage = chart.createBufferedImage(800, 600);
        byte[] bytes = ChartUtils.encodeAsPNG(bufferedImage);
        byte[] encode = Base64.getEncoder().encode(bytes);

        return new String(encode);
    }

    private JFreeChart createChart(final DefaultHighLowDataset dataset, String code, Date[] dateArray) {

        DateAxis timeAxis = new DateAxis("date");

        NumberAxis valueAxis = new NumberAxis("price");
        valueAxis.setAutoRangeIncludesZero(false);

        XYPlot plot = new XYPlot(dataset, timeAxis, valueAxis, null);
        plot.setRenderer(new CandlestickRenderer());

        return new JFreeChart(code, JFreeChart.DEFAULT_TITLE_FONT, plot, false);
    }
}
