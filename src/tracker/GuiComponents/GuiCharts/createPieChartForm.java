package tracker.GuiComponents.GuiCharts;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import java.util.Random;

public class createPieChartForm {

    /**
     * Creates a renderer for the specified colors.
     */
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param title  the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            series.add("Project " + ++k, value);
        }

        return series;
    }

    protected CategorySeries buildCategoryDatasetYesNo(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        series.add("Yes", values[0]);
        series.add("No", values[1]);
        return series;
    }

    protected CategorySeries buildCategoryDatasetCategorical(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values){                          //Change this to use value names instead.
            series.add("Project " + ++k, value);
        }

        return series;
    }

    public Form createPieChartForm() {
        // Generate the values
        double[] values = new double[]{12, 14, 11, 10, 19};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Form f = new Form("Budget", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();  //Pass back instead?
        return f;

    }

    public Form createYesNoPieChart(String title) {
        double[] values = new double[]{2, 3};  //Yes/No values in order. These will be a parameter strictly for testing.
        int[] colors = new int[]{ColorUtil.GREEN, ColorUtil.BLUE};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(24);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setHighlighted(true);

        PieChart chart = new PieChart(buildCategoryDatasetCategorical(title, values), renderer);

        ChartComponent c = new ChartComponent(chart);

        Form f = new Form(title, new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return f;
    }

    public Form createCategoricalPieChart(String title) {
        Random rand = new Random();
        double[] values = new double[]{2, 7, 1, 5, 6};
        int[] colors = new int[values.length];
        int i = 0;
        for (double value : values) {
            colors[i] = ColorUtil.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            i++;
            System.out.println("TEST");
        }
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(24);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setHighlighted(true);

        PieChart chart = new PieChart(buildCategoryDatasetCategorical(title, values), renderer);

        ChartComponent c = new ChartComponent(chart);

        Form f = new Form(title, new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return f;
    }
}
