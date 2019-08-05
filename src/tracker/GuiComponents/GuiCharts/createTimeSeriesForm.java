package tracker.GuiComponents.GuiCharts;
/**
 * Copyright (C) 2009 - 2013 SC 4ViewSoft SRL
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.views.PointStyle;
import com.codename1.charts.views.TimeChart;
import com.codename1.ui.Component;
import com.codename1.ui.Form;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.util.MathHelper;
import com.codename1.ui.layouts.BorderLayout;
import tracker.GuiComponents.GuiCharts.AbstractDemoChart;
import tracker.GuiComponents.GuiCharts.models.XYMultipleSeriesEditor;
import com.codename1.ui.Display;
import java.util.Random;

import static java.lang.Integer.parseInt;

/**
 * Temperature sensor demo chart.
 */
public class createTimeSeriesForm extends AbstractDemoChart {
    private XYMultipleSeriesDataset dataSet;
    private List<Date[]> x;

    private static final long HOUR = 3600 * 1000;

    private static final long DAY = HOUR * 24;

    private static final int HOURS = 24;

    /**
     * Returns the chart name.
     *
     * @return the chart name
     */
    public String getName() {
        return "Sensor data";
    }

    /**
     * Returns the chart description.
     *
     * @return the chart description
     */
    public String getDesc() {
        return "The temperature, as read from an outside and an inside sensors";
    }

    @Override
    public Component getChartModelEditor() {
        XYMultipleSeriesEditor x = new XYMultipleSeriesEditor();
        x.init(getDataSet());
        return x;
    }

    private XYMultipleSeriesDataset getDataSet() {
        if (dataSet == null) {
            String[] titles = new String[]{"Inside"}; //Change to y axis unit
            long now = Math.round(new Date().getTime() / DAY) * DAY;
            x = new ArrayList<Date[]>();
            for (int i = 0; i < titles.length; i++) {
                Date[] dates = new Date[HOURS];
                for (int j = 0; j < HOURS; j++) {
                    dates[j] = new Date(now - (HOURS - j) * HOUR);
                }
                x.add(dates);
            }
            List<double[]> values = new ArrayList<double[]>();

            values.add(new double[]{21.2, 21.5, 21.7, 21.5, 21.4, 21.4, 21.3, 21.1, 20.6, 20.3, 20.2,
                    19.9, 19.7, 19.6, 19.9, 20.3, 20.6, 20.9, 21.2, 21.6, 21.9, 22.1, 21.7, 21.5});
            values.add(new double[]{1.9, 1.2, 0.9, 0.5, 0.1, -0.5, -0.6, MathHelper.NULL_VALUE,
                    MathHelper.NULL_VALUE, -1.8, -0.3, 1.4, 3.4, 4.9, 7.0, 6.4, 3.4, 2.0, 1.5, 0.9, -0.5,
                    MathHelper.NULL_VALUE, -1.9, -2.5, -4.3});
            dataSet = buildDateDataset(titles, x, values);
        }
        return dataSet;
    }

    private XYMultipleSeriesDataset getCustomizedData() {
        //Needs Array of filenames for x axis
        ArrayList<String> fileName = new ArrayList<String>();
        fileName.add("2019.07.01");
        if (dataSet == null)
        {
            String[] titles = new String[]{"Y-axis Unit Here"};
            x = new ArrayList<Date[]>();
            Date[] dates = new Date[1];
            for (int i = 0; i < fileName.size(); i++){
                dates[0] = new Date(Integer.parseInt(fileName.get(i).substring(0, 3)), Integer.parseInt(fileName.get(i).substring(5, 6)),
                        Integer.parseInt(fileName.get(i).substring(8,9)));
            }
            x.add(dates);

            List<double[]> values = new ArrayList<double[]>();
            values.add(new double[]{21.2, 21.5, 21.7, 21.5, 21.4, 21.4, 21.3, 21.1, 20.6, 20.3, 20.2,
                    19.9, 19.7, 19.6, 19.9, 20.3, 20.6, 20.9, 21.2, 21.6, 21.9, 22.1, 21.7, 21.5});
            values.add(new double[]{1.9, 1.2, 0.9, 0.5, 0.1, -0.5, -0.6, MathHelper.NULL_VALUE,
                    MathHelper.NULL_VALUE, -1.8, -0.3, 1.4, 3.4, 4.9, 7.0, 6.4, 3.4, 2.0, 1.5, 0.9, -0.5,
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
        PointStyle[] styles = new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND};
        XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
        }

        // lazy initialization of x...
        getDataSet();
        setChartSettings(renderer, "Sensor temperature", "Hour", "Celsius degrees",
                x.get(0)[0].getTime(), x.get(0)[HOURS - 1].getTime(), -5, 30, ColorUtil.LTGRAY, ColorUtil.LTGRAY);

        int strWidth = Display.getInstance().convertToPixels(25);

        int numXLabels = Display.getInstance().getDisplayWidth() / (strWidth + 20);

        renderer.setXLabels(numXLabels);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Component.CENTER);
        renderer.setYLabelsAlign(Component.RIGHT);
        initRendererer(renderer);

        TimeChart chart = new TimeChart(getDataSet(),
                renderer);

        ChartComponent c = new ChartComponent(chart);

        Form f = new Form("Test", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return newChart(chart);
    }

    public Component getTimeSeriesForm(String title) {              //Pass in title, firstdate
        String firstdate = "07/31/2019";
        String nextdate = "Test";
        int[] colors = new int[]{ColorUtil.BLUE};
        PointStyle[] styles = new PointStyle[]{PointStyle.DIAMOND};
        XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
        }
        getCustomizedData();
        setChartSettings(renderer, title, "Date", "Measured unit",  //Change yTitle
                x.get(0)[0].getTime(), x.get(0)[length - 1].getTime(), -5, 30, ColorUtil.LTGRAY, ColorUtil.LTGRAY);  //x.get(0)[0].getDate(), x.get(0)[length - 1].getDate(), -5, 30

        int strWidth = Display.getInstance().convertToPixels(25);

        int numXLabels = Display.getInstance().getDisplayWidth() / (strWidth + 20);

        renderer.setXLabels(numXLabels);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Component.CENTER);
        renderer.setYLabelsAlign(Component.RIGHT);
        initRendererer(renderer);

        TimeChart chart = new TimeChart(getDataSet(), renderer);

        ChartComponent c = new ChartComponent(chart);

        Form f = new Form("Test", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return newChart(chart);
    }

    @Override
    protected void setChartSettings(XYMultipleSeriesRenderer renderer, String title, String xTitle,
                                    String yTitle, double xMin, double xMax, double yMin, double yMax, int axesColor,
                                    int labelsColor) {
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
