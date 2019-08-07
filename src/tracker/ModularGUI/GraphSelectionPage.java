package tracker.ModularGUI;

import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.PromptDataType;
import tracker.GuiComponents.Individual.GuiDatePicker;
import tracker.GuiComponents.Individual.GuiLabel;
import tracker.GuiComponents.Individual.GuiStringPicker;

import java.util.Date;
import java.util.Vector;

/**
 * Page for choosing a prompt, the type of graph,
 * and the time range to graph it over.
 */
public class GraphSelectionPage extends DefaultPageComponents {

    /** Name of the prompt selected by the user. */
    private String _PromptName;
    /** Type of graph selected selected by the user. */
    private GraphTypes _GraphType;
    /** Start date selected by the user. */
    private Date _StartDate;
    /** End date selected by the user. */
    private Date _EndDate;

    /**
     * Constructor for the DefaultComponents class.
     *
     * @param data     instance data
     * @param previous previous page
     */
    public GraphSelectionPage(final InstanceData data, final Form previous) {
        super(data, previous, "GraphChooser");

        createAllComponents();
    }

    /** Tells the user the prompt name is to be selected. */
    private GuiLabel _PromptLabel;
    /** Tells the user the graph type is to be selected. */
    private GuiLabel _GraphLabel;
    /** Tells the user the date range is to be set. */
    private GuiLabel _DateLabel;

    /** Picker for the prompt. */
    private GuiStringPicker _PromptPicker;

    /** Picker for the graph type. */
    private GuiStringPicker _GraphPicker;

    /** Picker for the start date. */
    private GuiDatePicker _DatePickerStart;

    /** Picker for the end date. */
    private GuiDatePicker _DatePickerEnd;

    private void createAllComponents() {
        initDefault();
        initConfirmButton();
        createDefaults();

        initPromptLabel();
        initPromptPicker();
        createPromptLabel();
        createPromptPicker();

        initGraphLabel();
        createGraphLabel();
        initGraphPicker();
        createGraphPicker();

        initDateLabel();
        createDateLabel();
        initDatePickers();
        createDatePickers();
    }


    private void initPromptLabel() {
        _PromptLabel = new GuiLabel("PromptLabel", getResources());
        _PromptLabel.setText("Choose Prompt:");
    }

    private void initGraphLabel() {
        _GraphLabel = new GuiLabel("GraphLabel", getResources());
        _GraphLabel.setText("Choose Graph Type:");
        _GraphLabel.setVisible(false);
    }

    private void initDateLabel() {
        _DateLabel = new GuiLabel("GraphLabel", getResources());
        _DateLabel.setText("Set Start & End Date:");
        _DateLabel.setVisible(false);
    }

    private void initPromptPicker() {
        _PromptPicker = new GuiStringPicker("PromptPicker", getResources());

        Vector<String> prompts = new Vector<>();

        int index = 0;
        while (index < getData().getInstancePrompts().getPromptCount() - 1) {
            prompts.add(getData().getSinglePrompt(++index).getName());
        }

        _PromptPicker.setStrings(prompts.toArray(new String[0]));
        _PromptPicker.setActionListener(new GraphSelectionCallback());
    }

    private void initGraphPicker() {
        _GraphPicker = new GuiStringPicker("GraphPicker", getResources());
        _GraphPicker.setVisible(false);

        _GraphPicker.setActionListener(new GraphSelectionCallback());
    }

    private void initDatePickers() {
        _DatePickerStart = new GuiDatePicker("StartDate", getResources());
        _DatePickerStart.setDate(null);
        _DatePickerEnd = new GuiDatePicker("EndDate", getResources());
        _DatePickerEnd.setDate(null);

        _DatePickerStart.setActionListener(new GraphSelectionCallback());
        _DatePickerEnd.setActionListener(new GraphSelectionCallback());
        _DatePickerStart.setVisible(false);
        _DatePickerEnd.setVisible(false);
    }


    private void createPromptLabel() {
        addComponent(_PromptLabel.getLabel());

        ((LayeredLayout) _PromptLabel.getLabel().getParent().getLayout()).
                setInsets(_PromptLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_PromptLabel.getLabel(),
                        getBackButton().getButton(), 2f);
    }

    private void createGraphLabel() {
        addComponent(_GraphLabel.getLabel());

        ((LayeredLayout) _GraphLabel.getLabel().getParent().getLayout()).
        setInsets(_GraphLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_GraphLabel.getLabel(),
                        getBackButton().getButton(), 4f);
    }

    private void createDateLabel() {
        addComponent(_DateLabel.getLabel());

        ((LayeredLayout) _DateLabel.getLabel().getParent().getLayout()).
                setInsets(_DateLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_DateLabel.getLabel(),
                        getBackButton().getButton(), 6f);
    }

    private void createPromptPicker() {
        addComponent(_PromptPicker.getPicker());
        _PromptPicker.centerAllign(true);

        ((LayeredLayout) _PromptPicker.getPicker().getParent().getLayout()).
                setInsets(_PromptPicker.getPicker(), "0 10% auto 5%").
                setReferenceComponentTop(_PromptPicker.getPicker(),
                        getBackButton().getButton(), 2.5f);
    }

    private void createGraphPicker() {
        addComponent(_GraphPicker.getPicker());
        _GraphPicker.centerAllign(true);

        ((LayeredLayout) _GraphPicker.getPicker().getParent().getLayout()).
                setInsets(_GraphPicker.getPicker(), "0 10% auto 5%").
                setReferenceComponentTop(_GraphPicker.getPicker(),
                        getBackButton().getButton(), 4.5f);
    }

    private void createDatePickers() {
        addComponent(_DatePickerStart.getPicker());
        _DatePickerStart.centerAllign(true);

        ((LayeredLayout) _DatePickerStart.getPicker().getParent().getLayout()).
                setInsets(_DatePickerStart.getPicker(), "0 10% auto 5%").
                setReferenceComponentTop(_DatePickerStart.getPicker(),
                        getBackButton().getButton(), 6.5f);

        addComponent(_DatePickerEnd.getPicker());
        _DatePickerEnd.centerAllign(true);

        ((LayeredLayout) _DatePickerEnd.getPicker().getParent().getLayout()).
                setInsets(_DatePickerEnd.getPicker(), "0 10% auto 5%").
                setReferenceComponentTop(_DatePickerEnd.getPicker(),
                        getBackButton().getButton(), 7f);
    }

    private void onPromptPicker() {
        _PromptName = _PromptPicker.getSelectedString();

        setGraphPickerContents();
        _GraphLabel.setVisible(true);
        _GraphPicker.setVisible(true);
    }

    private void onGraphPicker() {
        String selectedGraph = _GraphPicker.getSelectedString();
        _GraphType = GraphTypes.getGraphType(selectedGraph);

        _DateLabel.setVisible(true);
        _DatePickerStart.setVisible(true);
    }

    private void onDatePickerStart() {
        _StartDate = _DatePickerStart.getDate();

        if ((_StartDate.after(new Date())) || (_StartDate.equals(new Date()))) {
            Dialog.show(
                    "Invalid Date",
                    "Start date must be before today",
                    "OK!",
                    null
            );
            _StartDate = null;
            _DatePickerStart.setDate(null);
        } else {
            _DatePickerEnd.setVisible(true);
        }
    }

    private void onDatePickerEnd() {
        _EndDate = _DatePickerEnd.getDate();

        if ((_EndDate.before(_StartDate)) || (_EndDate.equals(_StartDate))) {
            Dialog.show(
                    "Invalid Date",
                    "End date needs to be before start",
                    "OK!",
                    null
            );
            _EndDate = null;
            _DatePickerEnd.setDate(null);
        }
    }

    /**
     * Create the graph page here and display it.
     * Load all data in range to be implemented through an additional class.
     */
    @Override
    void onConfirmButton() {
        if (checkInputComplete()) {
            if (_GraphType == GraphTypes.PIE_CHART) {
                double[] tempVals = new double[]{10, 20};
                String[] tempNames = new String[]{"Yes", "No"};
                CreatePieChartForm temp = new CreatePieChartForm();
                temp.createCategoricalPieChart(
                        _PromptName,
                        tempNames,
                        tempVals
                );
            } else if (_GraphType == GraphTypes.TREND_LINE) {
                CreateDaySeriesForm temp = new CreateDaySeriesForm();
                temp.getDaySeriesForm(_PromptName, "Day", "Unit");

            }

        }
    }

    private boolean checkInputComplete() {
        boolean complete = true;
        String message = null;

        if (_PromptName == null) {
            message = "Start by choosing a prompt";
            complete = false;
        } else if (_GraphType == null) {
            message = "Select the graph type";
            complete = false;
        } else if (_EndDate == null) {
            message = "Set the start date";
            complete = false;
        } else if (_StartDate == null) {
            message = "Set the end date";
            complete = false;
        }

        if (message != null) {
            Dialog.show("Missing Info", message, "OK", null);
        }

        return complete;
    }

    class GraphSelectionCallback implements ActionListener {

        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(final ActionEvent evt) {
            String sourceName = evt.getComponent().getName();

            if (sourceName.equals(_PromptPicker.getName())) {
                onPromptPicker();
            } else if (sourceName.equals(_GraphPicker.getName())) {
                onGraphPicker();
            } else if (sourceName.equals(_DatePickerStart.getName())) {
                onDatePickerStart();
            } else if (sourceName.equals(_DatePickerEnd.getName())) {
                onDatePickerEnd();
            }
        }
    }

    private void setGraphPickerContents() {
        if (_PromptName == null) {
            return;
        }
        PromptDataType dataType = getData().getTypeFromName(_PromptName);

        if (dataType == null) {
            return;
        }
        GraphTypes[] types = GraphTypes.getGraphTypes(dataType);

        Vector<String> graphNames = new Vector<>();
        for (GraphTypes type: types) {
            graphNames.add(type.getNameString());
        }

        _GraphPicker.setStrings(graphNames.toArray(new String[0]));
    }
}
