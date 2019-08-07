package tracker.Pages.ModularGUI;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import java.util.Random;

public class CreatePieChartForm {


    private DefaultRenderer buildCategoryRenderer(final int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(30);
        renderer.setLegendTextSize(30);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }



    protected CategorySeries buildCategoryDatasetCategorical(
            final String title, final double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            //Change this to use value names instead.
            series.add("Project " + ++k, value);
        }

        return series;
    }


    public Form createYesNoPieChart(final String title) {
        /**
         * this array will be sorted before hand and passed as a parameter.
         */
        double[] values = new double[]{2, 3};
        int[] colors = new int[]{ColorUtil.GREEN, ColorUtil.BLUE};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(24);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setHighlighted(true);

        PieChart chart = new PieChart(
                buildCategoryDatasetCategorical(title, values), renderer);

        ChartComponent c = new ChartComponent(chart);

        Form f = new Form(title, new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return f;
    }

    public Form createCategoricalPieChart(
            final String title,
            final String[] tallyNames,
            final double[] tally) {

        Random rand = new Random();
        /**
         * this array will be sorted before hand and passed as a parameter.
         */
        //double[] values = new double[]{2, 7, 1, 5, 6};
        int[] colors = new int[tally.length];
        int i = 0;
        for (double value : tally) {
            colors[i] = ColorUtil.rgb(
                    rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            i++;
        }
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(24);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setHighlighted(true);

        PieChart chart = new PieChart(buildCategoryDatasetCategorical(
                title, tally), renderer);

        ChartComponent c = new ChartComponent(chart);

        Form f = new Form(title, new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        f.show();
        return f;
    }
}
