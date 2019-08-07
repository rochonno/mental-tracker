package tracker.ModularGUI;

import tracker.Data.Prompts.PromptDataType;

import java.util.Vector;

/**
 * Types of supported graphs.
 */
public enum GraphTypes {

    /** All types of available graphs. */
    SCATTER_PLOT, TREND_LINE, PIE_CHART;

    /** Type of graph in String form. */
    private static final String _Scatter = "Scatter Plot";
    /** Type of graph in String form. */
    private static final String _Trend = "Trend Line";
    /** Type of graph in String form. */
    private static final String _Pie = "Pie Chart";

    public static GraphTypes[] getGraphTypes(final PromptDataType dataType) {
        Vector<GraphTypes> types = new Vector<>();

        switch (dataType) {
            case INT:
            case DOUBLE:
                types.add(SCATTER_PLOT);
                types.add(TREND_LINE);
                types.add(PIE_CHART);
                break;
            case BOOL:
                types.add(PIE_CHART);
                break;
            case STRING:
                break;
            default: break;
        }

        return types.toArray(new GraphTypes[0]);
    }

    public String getNameString() {
        switch (this) {
            case SCATTER_PLOT: return _Scatter;
            case TREND_LINE: return _Trend;
            case PIE_CHART: return _Pie;
            default: return null;
        }
    }

    public static GraphTypes getGraphType(final String type) {

        switch (type) {
            case _Scatter: return SCATTER_PLOT;
            case _Trend: return TREND_LINE;
            case _Pie: return PIE_CHART;
            default: return null;
        }
    }
}
