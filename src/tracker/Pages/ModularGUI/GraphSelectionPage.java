package tracker.Pages.ModularGUI;

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

public class GraphSelectionPage extends DefaultPageComponents {

    private String _PromptName;
    private GraphTypes _GraphType;
    private Date _StartDate;
    private Date _EndDate;

    /**
     * Constructor for the DefaultComponents class.
     *
     * @param data     instance data
     * @param previous previous page
     */
    public GraphSelectionPage(InstanceData data, Form previous) {
        super(data, previous, "GraphChooser");

        createAllComponents();
    }

    private GuiLabel _PromptLabel;
    private GuiLabel _GraphLabel;
    private GuiLabel _DateLabel;

    private GuiStringPicker _PromptPicker;

    private GuiStringPicker _GraphPicker;

    private GuiDatePicker _DatePickerStart;

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
    }

    private void initDateLabel() {
        _DateLabel = new GuiLabel("GraphLabel", getResources());
        _DateLabel.setText("Set Start & End Date:");
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
        _DatePickerEnd = new GuiDatePicker("EndDate", getResources());

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
        String selectedPrompt = _PromptPicker.getSelectedString();

        setGraphPickerContents(selectedPrompt);
        _GraphPicker.setVisible(true);
    }

    private void onGraphPicker() {
        String selectedGraph = _GraphPicker.getSelectedString();

        _DatePickerStart.setVisible(true);
        _DatePickerEnd.setVisible(true);
    }

    private void onDatePickerStart() {
        _StartDate = _DatePickerStart.getDate();
    }

    private void onDatePickerEnd() {
        _EndDate = _DatePickerEnd.getDate();
    }

    @Override
    void onConfirmButton() {
        if (isInputComplete()) {

        } else {

        }
    }

    private void isInputComplete() {

    }

    class GraphSelectionCallback implements ActionListener {

        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
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

    private void setGraphPickerContents(String promptName) {
        PromptDataType dataType = getData().getTypeFromName(promptName);

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
