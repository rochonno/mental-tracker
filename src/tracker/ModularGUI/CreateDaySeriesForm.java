/**
 * @Author Douglas Yacenick
 * Code partially modeled off of Steve Hannah from Codename One.
 * In compliance of Apache License.
 *
 * Class renders user supplied data to display a line graph.
 */
package tracker.ModularGUI;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.views.LineChart;
import com.codename1.charts.views.PointStyle;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.layouts.BorderLayout;
import tracker.GuiComponents.GuiCharts.AbstractDemoChart;
import tracker.GuiComponents.GuiCharts.models.XYMultipleSeriesEditor;

public class CreateDaySeriesForm extends AbstractDemoChart {

    /** Dataset for MultipleSeries. */
    private XYMultipleSeriesDataset dataset;

    /**
     * Included to adhere to contract.
     * @return Name of the graph.
     */
    public String getName() {
        return "Average temperature";
    }


    /**
     * Included to adhere to contract.
     * @return Brief description of graph.
     */
    public String getDesc() {
        return "The average temperature in 4 Greek islands (line chart)";
    }

    @Override
    public Component getChartModelEditor() {
        XYMultipleSeriesEditor x = new XYMultipleSeriesEditor();
        x.init(getDataSet());
        return x;
    }

    @Override
    public String getChartTitle() {
        return "Average temperature";
    }

    private XYMultipleSeriesDataset getDataSet() {
        if (dataset == null) {
            dataset = createTemperatureDataset();
        }
        return dataset;
    }

    @Override
    public Component execute() {
        int[] colors = new int[] {ColorUtil.BLUE,
                ColorUtil.GREEN, ColorUtil.CYAN, ColorUtil.YELLOW};
        PointStyle[] styles = new PointStyle[]{
                PointStyle.CIRCLE, PointStyle.DIAMOND,
                PointStyle.TRIANGLE, PointStyle.SQUARE};
        XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).
                    setFillPoints(true);
        }
        setChartSettings(renderer, "Average temperature",
                "Month", "Temperature", 0, 12, -10, 40,
                ColorUtil.LTGRAY, ColorUtil.LTGRAY);
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Component.CENTER);
        renderer.setYLabelsAlign(Component.RIGHT);
        renderer.setZoomButtonsVisible(true);
        renderer.setPanLimits(new double[]{-10, 20, -10, 40});
        renderer.setZoomLimits(new double[]{-10, 20, -10, 40});
        renderer.setZoomEnabled(true);
        renderer.setZoomRate(10);
        initRendererer(renderer);

        XYMultipleSeriesDataset dataset = getDataSet();

        XYSeriesRenderer r = (XYSeriesRenderer) renderer.getSeriesRendererAt(0);
        r.setAnnotationsColor(ColorUtil.GREEN);

        LineChart chart = new LineChart(dataset, renderer);
        ChartComponent c = newChart(chart);



        Form f = new Form("test", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return f;

    }

    /**
     * Creates a line graph tailored for our application's program.
     * @param title Name of the prompt to generate a line graph for.
     * @param xAxis Name of the x-axis.
     * @param yAxis Name of the y-axis.
     * @return Form with the line graph on it.
     */
    public Component getDaySeriesForm(
            final String title,
            final String xAxis,
            final String yAxis)  {
        int[] colors = new int[]{ColorUtil.BLUE};
        PointStyle[] styles = new PointStyle[]{PointStyle.DIAMOND};
        XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).
                    setFillPoints(true);
        }
        setChartSettings(renderer, title, xAxis, yAxis, 0, 12, -10, 40,
                ColorUtil.LTGRAY, ColorUtil.LTGRAY);

        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Component.CENTER);
        renderer.setYLabelsAlign(Component.RIGHT);
        renderer.setZoomButtonsVisible(true);
        renderer.setPanLimits(new double[]{-10, 20, -10, 40});
        renderer.setZoomLimits(new double[]{-10, 20, -10, 40});
        renderer.setZoomEnabled(true);
        renderer.setZoomRate(10);
        initRendererer(renderer);

        XYMultipleSeriesDataset dataset = getDataSet();

        XYSeriesRenderer r = (XYSeriesRenderer) renderer.getSeriesRendererAt(0);
        r.setAnnotationsColor(ColorUtil.GREEN);

        LineChart chart = new LineChart(dataset, renderer);
        ChartComponent c = newChart(chart);

        Form f = new Form("test", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return f;
    }
}
