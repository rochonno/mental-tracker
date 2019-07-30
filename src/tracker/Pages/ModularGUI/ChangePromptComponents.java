package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.PromptDataType;
import tracker.GuiComponents.Individual.GuiLabel;
import tracker.GuiComponents.Individual.GuiPicker;
import tracker.GuiComponents.Individual.GuiStringPicker;
import tracker.GuiComponents.Individual.GuiTextArea;

import java.util.List;

import static tracker.Data.Prompts.PromptDataType.*;

/******************************************************************************
 * A parent class for creating/changing a prompt.
 * Meant to be extended.
 * Child class of DefaultPageComponents.
 *      Adds to this by creating the components needed to edit/create a prompt.
 *
 * setTextAreas() must be called if editing an existing prompt
 ******************************************************************************/
class ChangePromptComponents extends DefaultPageComponents {

    /** The prompt being changed (can be null). */
    private MentalPrompt _CurrPrompt;
    /** The new prompts after creating or changing one. */
    private MentalPrompt _NewPrompt;

    /** Text Area for name of prompt. */
    private GuiTextArea _NameTextArea;
    /** Text Area for question of prompt. */
    private GuiTextArea _PromptTextArea;
    /** Text Area for expected answer type of prompt. */
    private GuiStringPicker _PickerType;
    /** Text Area for min of prompt. */
    private GuiTextArea _MinTextArea;
    /** Text Area for max of prompt. */
    private GuiTextArea _MaxTextArea;

    private GuiLabel _NameLabel;
    private GuiLabel _PromptLabel;
    private GuiLabel _TypeLabel;
    private GuiLabel _MinLabel;
    private GuiLabel _MaxLabel;

    private static final String[] _Types = {"slider", "yes/no", "number", "text"};

    /**
     * Constructor for this parent class
     *
     * @param data All the current data for this instance of the app
     * @param previous The previous Form
     *                 (usually the form creating this one)
     * @param target The intended Prompt to be changed
     *               If creating a new prompt, pass null to this
     * @param pageName Name of the page being created
     */
    ChangePromptComponents(
            final InstanceData data,
            Form previous,
            final MentalPrompt target,
            final String pageName) {
        super(data, previous, pageName);

        if (target != null) {
            _NewPrompt = target;
        } else {
            _NewPrompt = new MentalPrompt(null, null, null);
        }
        _CurrPrompt = target;

        createDefaultComponents();
        initInputLabels();
        initInputFields();
        createInputLabels();
        createInputFields();
    }

    /**
     * Initializes and adds the components.
     */
    private void createDefaultComponents() {
        initDefault();
        initConfirmButton();
        createComponents();
    }

    private void initInputLabels() {
        _NameLabel = new GuiLabel("Name", getResources());
        _NameLabel.setText("Name:");

        _PromptLabel = new GuiLabel("Question", getResources());
        _PromptLabel.setText("Question:");

        _TypeLabel = new GuiLabel("Type", getResources());
        _TypeLabel.setText("Answer Type:");

        _MinLabel = new GuiLabel("Min", getResources());
        _MinLabel.setText("Min:");

        _MaxLabel = new GuiLabel("Max", getResources());
        _MaxLabel.setText("Max:");
    }

    /**
     * Initializes the input fields (without text).
     */
    private void initInputFields() {
        ChangePromptCallback callback = new ChangePromptCallback();

        _NameTextArea = new GuiTextArea("Name", getResources());
        _NameTextArea.setHint("Question Title");
        _NameTextArea.setActionListener(callback);

        _PromptTextArea = new GuiTextArea("Prompt", getResources());
        _PromptTextArea.setHint("Prompt goes here");
        _PromptTextArea.setSingleLine(true);
        _PromptTextArea.setActionListener(callback);

        _PickerType = new GuiStringPicker("Answer Type");
        _PickerType.setStrings(_Types);
        _PickerType.setActionListener(callback);

        _MinTextArea = new GuiTextArea("Min", getResources());
        _MinTextArea.setHint("For slider & number");
        _MinTextArea.setActionListener(callback);

        _MaxTextArea = new GuiTextArea("Max", getResources());
        _MaxTextArea.setHint("For slider & number");
        _MaxTextArea.setActionListener(callback);

    }

    /**
     * Sets the textAreas to contain the values of the existing prompt.
     * Used for editing a prompt only.
     */
    void setTextAreas() {
        if (_CurrPrompt == null) {
            return;
        }

        _NameTextArea.setText(_CurrPrompt.getName());
        _PromptTextArea.setText(_CurrPrompt.getPrompt());
        _PickerType.setSelectedString(getTextFromAnswer());
        _MinTextArea.setText(Integer.toString(_CurrPrompt.getMin()));
        _MaxTextArea.setText(Integer.toString(_CurrPrompt.getMax()));

        updateMinMaxState();
    }

    private void updateMinMaxState() {
        if ((_PickerType.getSelectedString().equals(_Types[0]))
                || (_PickerType.getSelectedString().equals(_Types[2]))) {
            _MinTextArea.canEnter(true);
            _MaxTextArea.canEnter(true);
        } else {
            _MinTextArea.canEnter(false);
            _MaxTextArea.canEnter(false);
        }
    }

    /**
     * Parses the expected answer type into its respective input type.
     * @return text The resulting text to be displayed
     */
    private String getTextFromAnswer() {
        String text;
        switch (_CurrPrompt.getDataType()) {
            case INT: text = _Types[0]; break;
            case BOOL: text = _Types[1]; break;
            case DOUBLE: text = _Types[2]; break;
            case STRING: text = _Types[3]; break;
            default : text = "";break;
        }
        return text;
    }

    private void createInputLabels() {
        float location = 1.6f;
        createNameLabel(location);
        location += 1f;
        createPromptLabel(location);
        location += 1f;
        createTypeLabel(location);
        location += 1f;
        createMinLabel(location);
        location += 1f;
        createMaxLabel(location);
    }

    /**
     * Puts all the input fields onto the Form.
     */
    private void createInputFields() {
        float location = 2f;
        createNameTextArea(location);
        location += 1f;
        createPromptTextArea(location);
        location += 1f;
        createTypePicker(location);
        location += 1f;
        createMinTextArea(location);
        location += 1f;
        createMaxTextArea(location);
    }

    private void createNameLabel(final float position) {
        addComponent(_NameLabel.getLabel());
        _NameLabel.getLabel().setPreferredSizeStr("40mm 5mm");

        ((LayeredLayout) _NameLabel.getLabel().getParent().getLayout()).
                setInsets(_NameLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_NameLabel.getLabel(),
                        getBackButton().getButton(), position);
    }

    private void createPromptLabel(final float position) {
        addComponent(_PromptLabel.getLabel());
        _PromptLabel.getLabel().setPreferredSizeStr("40mm 5mm");

        ((LayeredLayout) _PromptLabel.getLabel().getParent().getLayout()).
                setInsets(_PromptLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_PromptLabel.getLabel(),
                        getBackButton().getButton(), position);
    }

    private void createTypeLabel(final float position) {
        addComponent(_TypeLabel.getLabel());
        _TypeLabel.getLabel().setPreferredSizeStr("40mm 5mm");

        ((LayeredLayout) _TypeLabel.getLabel().getParent().getLayout()).
                setInsets(_TypeLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_TypeLabel.getLabel(),
                        getBackButton().getButton(), position);
    }

    private void createMinLabel(final float position) {
        addComponent(_MinLabel.getLabel());
        _MinLabel.getLabel().setPreferredSizeStr("40mm 5mm");

        ((LayeredLayout) _MinLabel.getLabel().getParent().getLayout()).
                setInsets(_MinLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_MinLabel.getLabel(),
                        getBackButton().getButton(), position);
    }

    private void createMaxLabel(final float position) {
        addComponent(_MaxLabel.getLabel());
        _MaxLabel.getLabel().setPreferredSizeStr("40mm 5mm");

        ((LayeredLayout) _MaxLabel.getLabel().getParent().getLayout()).
                setInsets(_MaxLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_MaxLabel.getLabel(),
                        getBackButton().getButton(), position);
    }

    private void createNameTextArea(final float position) {
        addComponent(_NameTextArea.getTextArea());
        _NameTextArea.centerAllign(true);

        ((LayeredLayout) _NameTextArea.getTextArea().getParent().getLayout()).
                setInsets(_NameTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_NameTextArea.getTextArea(),
                        getBackButton().getButton(), position);
    }

    private void createPromptTextArea(final float position) {
        addComponent(_PromptTextArea.getTextArea());
        _PromptTextArea.centerAllign(true);

        ((LayeredLayout) _PromptTextArea.getTextArea().getParent().getLayout()).
                setInsets(_PromptTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_PromptTextArea.getTextArea(),
                        getBackButton().getButton(), position);
    }

    private void createMinTextArea(final float position) {
        addComponent(_MinTextArea.getTextArea());
        _MinTextArea.centerAllign(true);

        ((LayeredLayout) _MinTextArea.getTextArea().getParent().getLayout()).
                setInsets(_MinTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_MinTextArea.getTextArea(),
                        getBackButton().getButton(), position);
    }

    private void createMaxTextArea(final float position) {
        addComponent(_MaxTextArea.getTextArea());
        _MaxTextArea.centerAllign(true);

        ((LayeredLayout) _MaxTextArea.getTextArea().getParent().getLayout()).
                setInsets(_MaxTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_MaxTextArea.getTextArea(),
                        getBackButton().getButton(), position);
    }

    private void createTypePicker(final float position) {
        addComponent(_PickerType.getPicker());
        _PickerType.centerAllign(true);

        ((LayeredLayout) _PickerType.getPicker().getParent().getLayout()).
                setInsets(_PickerType.getPicker(), "0 10% auto 5%").
                setReferenceComponentTop(_PickerType.getPicker(),
                        getBackButton().getButton(), position);
    }

    @Override
    void onConfirmButton() {

    }

    /**
     * Called with the prompt name text area is changed.
     */
    private void onNameTextArea() {
        _NewPrompt.setName(_NameTextArea.getText());
        //TODO: check if empty
    }

    /**
     * Called when the question text area is changed.
     */
    private void onPromptTextArea() {
        _NewPrompt.setPrompt(_PromptTextArea.getText());
        //TODO:: check if empty
    }

    /**
     * Called when the answer type is changed.
     */
    private void onPickerType() {
        String selected = _PickerType.getSelectedString();
        if (selected.equals(_Types[0])) {
            _NewPrompt.setDataType(INT);
        } else if (selected.equals(_Types[1])) {
            _NewPrompt.setDataType(BOOL);
        } else if (selected.equals(_Types[2])) {
            _NewPrompt.setDataType(DOUBLE);
        } else if (selected.equals(_Types[3])) {
            _NewPrompt.setDataType(STRING);
        }

        updateMinMaxState();
    }

    /**
     * Called when the min text area is changed.
     */
    private void onMinTextArea() {
        _NewPrompt.setMin(Integer.parseInt(_MinTextArea.getText()));
        //TODO: check for valid input
    }

    /**
     * Called when the max text area is changed
     */
    private void onMaxTextArea() {
        _NewPrompt.setMin(Integer.parseInt(_MaxTextArea.getText()));
        //TODO: check for valid input
    }

    /**
     * Event callback for the components in ChangePromptComponents class.
     */
    class ChangePromptCallback implements ActionListener {

        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            String sourceName = evt.getComponent().getName();

            if (sourceName.equals(_NameTextArea.getName())) {
                onNameTextArea();
            } else if (sourceName.equals(_PromptTextArea.getName())) {
                onPromptTextArea();
            } else if (sourceName.equals(_PickerType.getName())) {
                onPickerType();
            } else if (sourceName.equals(_MinTextArea.getName())) {
                onMinTextArea();
            } else if (sourceName.equals(_MaxTextArea.getName())) {
                onMaxTextArea();
            }
        }
    }

    MentalPrompt getTargetPrompt() {
        return _CurrPrompt;
    }

    MentalPrompt getNewPrompt() {
        return _NewPrompt;
    }

}
