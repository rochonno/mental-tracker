/**
 * @Author Douglas Yacenick
 * Code partially modeled off of Steve Hannah from Codename One.
 * in compliance of Apache License.
 *
 * Class renders user supplied data to display a pie chart.
 */

package tracker.ModularGUI;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import java.util.Random;

/**
 * Creates a pie chart form. Originally meant for yes/no questions.
 */
public class CreatePieChartForm {

    /**
     * @param colors An integer array of color values to render
     *               labels/piece colors.
     * @return renderer for GUI.
     */
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


    /**Adds Categorical string names to pie chart.
     * @param title Name of prompt for the chart to be built.
     * @param values Double values of the frequency of each
     *               categorical variable.
     * @return CategorySeries.
     */
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

    /**Tailors a pie chart specifically for yes/no questions.
     * @param title Name of prompt for the chart to be built.
     * @return Form component with pie chart displayed.
     */
    public Form createYesNoPieChart(final String title) {

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

    /**
     * @param title Name of the prompt for chart to be built.
     * @param tallyNames Array of Categorical variable names.
     * @param tally Array passed in with frequencies of corresponding
     *              categorical variables.
     * @return Form component with the pie chart.
     */
    public Form createCategoricalPieChart(
            final String title,
            final String[] tallyNames,
            final double[] tally) {

        Random rand = new Random();
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
