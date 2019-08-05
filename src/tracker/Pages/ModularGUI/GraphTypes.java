package tracker.Pages.ModularGUI;

import tracker.Data.Prompts.PromptDataType;

import java.util.Vector;

public enum GraphTypes {

    SCATTER_PLOT, TREND_LINE, PIE_CHART;

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
            case SCATTER_PLOT: return "Scatter Plot";
            case TREND_LINE: return "Trend Line";
            case PIE_CHART: return "Pie Chart";
            default: return null;
        }
    }
}
