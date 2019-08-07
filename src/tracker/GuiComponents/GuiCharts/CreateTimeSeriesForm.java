/**
 * Code partially modeled off of Steve Hannah from Codename One.
 * In compliance of Apache License.
 *
 * Class renders user supplied data to display a Time Series graph.
 *
 * @Author Douglas Yacenick
 */
package tracker.GuiComponents.GuiCharts;


import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.views.PointStyle;
import com.codename1.charts.views.TimeChart;
import com.codename1.ui.Component;
import com.codename1.ui.Form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.util.MathHelper;
import com.codename1.ui.layouts.BorderLayout;
import tracker.GuiComponents.GuiCharts.AbstractDemoChart;
import tracker.GuiComponents.GuiCharts.models.XYMultipleSeriesEditor;
import com.codename1.ui.Display;


public class CreateTimeSeriesForm extends AbstractDemoChart {
    /** Instance of XYMultipleSeiresDataset. */
    private XYMultipleSeriesDataset dataSet;
    /** Instance of a list of dates. */
    private List<Date[]> x;
    private static final long HOUR = 3600 * 1000;

    private static final long DAY = HOUR * 24;

    private static final int HOURS = 24;

    /**
     * Returns the chart name.
     *
     * @return the chart name.
     */
    public String getName() {
        return "Sensor data";
    }

    /**
     * Returns the chart description.
     *
     * @return the chart description.
     */
    public String getDesc() {
        return "The temperature, as read from an outside and an inside sensors";
    }

    @Override
    public Component getChartModelEditor() {
        XYMultipleSeriesEditor x = new XYMultipleSeriesEditor();
        x.init(getCustomizedData());
        return x;
    }

    private XYMultipleSeriesDataset getCustomizedData() {
        //Needs Array of filenames for x axis
        ArrayList<String> fileName = new ArrayList<String>();
        fileName.add("2019.07.01");
        if (dataSet == null) {
            String[] titles = new String[]{"Y-axis Unit Here"};
            x = new ArrayList<Date[]>();
            Date[] dates = new Date[1];
            for (int i = 0; i < fileName.size(); i++) {
                dates[0] = new Date(Integer.parseInt(fileName.get(i).
                        substring(0, 3)),
                        Integer.parseInt(fileName.get(i).substring(5, 6)),
                        Integer.parseInt(fileName.get(i).substring(8, 9)));
            }
            x.add(dates);

            List<double[]> values = new ArrayList<double[]>();
            values.add(new double[]{21.2, 21.5, 21.7, 21.5, 21.4,
                    21.4, 21.3, 21.1, 20.6, 20.3, 20.2,
                    19.9, 19.7, 19.6, 19.9, 20.3, 20.6, 20.9, 21.2,
                    21.6, 21.9, 22.1, 21.7, 21.5});
            values.add(new double[]{1.9, 1.2, 0.9, 0.5, 0.1, -0.5,
                    -0.6, MathHelper.NULL_VALUE,
                    MathHelper.NULL_VALUE, -1.8, -0.3, 1.4, 3.4, 4.9,
                    7.0, 6.4, 3.4, 2.0, 1.5, 0.9, -0.5,
                    MathHelper.NULL_VALUE, -1.9, -2.5, -4.3});
            dataSet = buildDateDataset(titles, x, values);
        }
        return dataSet;
    }

    @Override
    public String getChartTitle() {
        return "h:mm a";
    }

    @Override
    public Component execute() {
        int[] colors = new int[]{ColorUtil.GREEN, ColorUtil.BLUE};
        PointStyle[] styles =
                new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND};
        XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).
                    setFillPoints(true);
        }

        // lazy initialization of x...
        getCustomizedData();
        setChartSettings(renderer,
                "Sensor temperature", "Hour", "Celsius degrees",
                x.get(0)[0].getTime(), x.get(0)[HOURS - 1].getTime(),
                -5, 30, ColorUtil.LTGRAY, ColorUtil.LTGRAY);

        int strWidth = Display.getInstance().convertToPixels(25);

        int numXLabels =
                Display.getInstance().getDisplayWidth() / (strWidth + 20);

        renderer.setXLabels(numXLabels);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Component.CENTER);
        renderer.setYLabelsAlign(Component.RIGHT);
        initRendererer(renderer);

        TimeChart chart = new TimeChart(getCustomizedData(),
                renderer);

        ChartComponent c = new ChartComponent(chart);

        Form f = new Form("Test", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return newChart(chart);
    }

    //Pass in title, firstdate
    public Component getTimeSeriesForm(final String title) {
        String firstdate = "07/31/2019";
        String nextdate = "Test";
        int[] colors = new int[]{ColorUtil.BLUE};
        PointStyle[] styles = new PointStyle[]{PointStyle.DIAMOND};
        XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).
                    setFillPoints(true);
        }
        getCustomizedData();
        setChartSettings(renderer, title,
                "Date", "Measured unit",  //Change yTitle
                x.get(0)[0].getTime(), x.get(0)[length - 1].getTime(),
                -5, 30, ColorUtil.LTGRAY, ColorUtil.LTGRAY);
        //x.get(0)[0].getDate(), x.get(0)[length - 1].getDate(), -5, 30

        int strWidth =
                Display.getInstance().convertToPixels(25);

        int numXLabels =
                Display.getInstance().getDisplayWidth() / (strWidth + 20);

        renderer.setXLabels(numXLabels);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Component.CENTER);
        renderer.setYLabelsAlign(Component.RIGHT);
        initRendererer(renderer);

        TimeChart chart = new TimeChart(getCustomizedData(), renderer);

        ChartComponent c = new ChartComponent(chart);

        Form f = new Form("Test", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return newChart(chart);
    }

    @Override
    protected void setChartSettings(
            final XYMultipleSeriesRenderer renderer,
            final String title,
            final String xTitle,
            final String yTitle,
            final double xMin,
            final double xMax,
            final double yMin,
            final double yMax,
            final int axesColor,
            final int labelsColor) {
        renderer.setChartTitle(title);
        renderer.setXTitle(xTitle);
        renderer.setYTitle(yTitle);
        renderer.setXAxisMin(xMin);
        renderer.setXAxisMax(xMax);
        renderer.setYAxisMin(yMin);
        renderer.setYAxisMax(yMax);
        renderer.setAxesColor(axesColor);
        renderer.setLabelsColor(labelsColor);
    }
}
