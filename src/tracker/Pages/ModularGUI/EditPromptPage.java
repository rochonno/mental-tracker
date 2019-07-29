package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.PromptDataType;
import tracker.GuiComponents.ImageNames;
import tracker.GuiComponents.Individual.GuiButton;
import tracker.GuiComponents.Individual.GuiLabel;
import tracker.GuiComponents.Individual.GuiTextArea;

public class EditPromptPage extends Form {

    private Form _PreviousForm;
    private Resources _ResourceInstance;

    private InstanceData _Data;
    private MentalPrompt _OriginalPrompt;
    private MentalPrompt _NewPrompt;

    private GuiLabel _TopInset;
    private GuiButton _BackButton;
    private GuiButton _ConfirmButton;

    private GuiTextArea _NameTextArea;
    private GuiTextArea _PromptTextArea;
    private GuiTextArea _ResponseTextArea;
    private GuiTextArea _MinTextArea;
    private GuiTextArea _MaxTextArea;

    public EditPromptPage(InstanceData data, Form previous, MentalPrompt target) {
        _PreviousForm = previous;
        _Data = data;
        _OriginalPrompt = target;
        _NewPrompt = _OriginalPrompt;
        _ResourceInstance = Resources.getGlobalResources();

        initializeLayout();
    }

    private void initializeLayout() {
        setLayout(new LayeredLayout());
        setInlineStylesTheme(_ResourceInstance);
        setScrollableY(true);
        setInlineStylesTheme(_ResourceInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Mental Tracker");
        setName("Edit Question");

        createDefaultComponents();
    }

    private void createDefaultComponents() {
        EditPromptCallback callback = new EditPromptCallback();

        _TopInset = new GuiLabel("TopInset", _ResourceInstance);

        _BackButton = new GuiButton(
                ImageNames.BACK_UNSELECT,
                _ResourceInstance,
                ImageNames.BACK_UNSELECT,
                ImageNames.BACK_SELECT
        );
        _BackButton.setActionListener(callback);

        _ConfirmButton = new GuiButton(
                ImageNames.CONTINUE_UNSELECT,
                _ResourceInstance,
                ImageNames.CONTINUE_UNSELECT,
                ImageNames.CONTINUE_SELECT

        );
        _ConfirmButton.setActionListener(callback);

        createInputFields(callback);
        initializeComponents();
    }

    private void createInputFields(ActionListener callback) {
        _NameTextArea = new GuiTextArea("Name", _ResourceInstance);
        _NameTextArea.setHint("Question Title");
        _NameTextArea.setText(_OriginalPrompt.getName());
        _NameTextArea.setActionListener(callback);

        _PromptTextArea = new GuiTextArea("Prompt", _ResourceInstance);
        _PromptTextArea.setHint("Prompt goes here");
        _PromptTextArea.setText(_OriginalPrompt.getPrompt());
        _PromptTextArea.setActionListener(callback);

        _ResponseTextArea = new GuiTextArea("Type", _ResourceInstance);
        _ResponseTextArea.setHint("slider, yes/no, number, words");
        _ResponseTextArea.setActionListener(callback);
        _ResponseTextArea.setText(getAnswerFromText());

        _MinTextArea = new GuiTextArea("Min", _ResourceInstance);
        _MinTextArea.setHint("Min (for slider/number)");
        _MinTextArea.setText(Integer.toString(_OriginalPrompt.getMin()));
        _MinTextArea.setActionListener(callback);

        _MaxTextArea = new GuiTextArea("Max", _ResourceInstance);
        _MaxTextArea.setHint("Max (for slider/number)");
        _MaxTextArea.setText(Integer.toString(_OriginalPrompt.getMax()));
        _MaxTextArea.setActionListener(callback);
    }

    private String getAnswerFromText() {
        String text = "";
        switch (_OriginalPrompt.getDataType()) {
            case INT: text = "slider"; break;
            case BOOL: text = "yes/no"; break;
            case DOUBLE: text = "number"; break;
            case STRING: text = "words"; break;
            default : break;
        }
        return text;
    }

    private void initializeComponents() {
        initTopInset();
        initBackButton();
        initConfirmButton();

        initNameTextArea();
        initPromptTextArea();
        initResponseTextArea();
        initMinTextArea();
        initMaxTextArea();
    }

    private void initTopInset() {
        _TopInset.setSizeStr("inherit 4.2328043mm");
        _TopInset.getLabel();
        addComponent(_TopInset.getLabel());

        ((LayeredLayout) _TopInset.getLabel().
                getParent().getLayout()).setInsets(
                _TopInset.getLabel(),
                "1.6mm 5.0mm auto 5.0mm").
                setReferenceComponents(
                        _TopInset.getLabel(), "-1 -1 -1 -1").
                setReferencePositions(
                        _TopInset.getLabel(), "0.0 0.0 0.0 0.0");
    }

    private void initBackButton() {
        _BackButton.setSizeStr("20.042328mm 10.8465605mm");
        addComponent(_BackButton.getButton());

        ((LayeredLayout) _BackButton.getButton().
                getParent().getLayout()).setInsets(
                _BackButton.getButton(),
                "0.5mm auto auto 0.0mm").
                setReferenceComponents(
                        _BackButton.getButton(), "0 -1 -1 0 ").
                setReferencePositions(
                        _BackButton.getButton(), "-1 0.0 0.0 0.0");
    }

    private void initConfirmButton() {
        _ConfirmButton.setSizeStr( "116.93122mm 23.544973mm");
        addComponent(_ConfirmButton.getButton());

        ((LayeredLayout) _ConfirmButton.getButton().
                getParent().getLayout()).setInsets(
                _ConfirmButton.getButton(),
                "auto -125% 0 auto");
    }

    private void initNameTextArea() {
        addComponent(_NameTextArea.getTextArea());
        _NameTextArea.centerAllign(true);

        ((LayeredLayout) _NameTextArea.getTextArea().getParent().getLayout()).
                setInsets(_NameTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_NameTextArea.getTextArea(),
                        _BackButton.getButton(), 3f);
    }

    private void initPromptTextArea() {
        addComponent(_PromptTextArea.getTextArea());
        _PromptTextArea.centerAllign(true);

        ((LayeredLayout) _PromptTextArea.getTextArea().getParent().getLayout()).
                setInsets(_PromptTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_PromptTextArea.getTextArea(),
                        _BackButton.getButton(), 4f);
    }

    private void initResponseTextArea() {
        addComponent(_ResponseTextArea.getTextArea());
        _ResponseTextArea.centerAllign(true);

        ((LayeredLayout) _ResponseTextArea.getTextArea().getParent().getLayout()).
                setInsets(_ResponseTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_ResponseTextArea.getTextArea(),
                        _BackButton.getButton(), 5f);
    }

    private void initMinTextArea() {
        addComponent(_MinTextArea.getTextArea());
        _MinTextArea.centerAllign(true);

        ((LayeredLayout) _MinTextArea.getTextArea().getParent().getLayout()).
                setInsets(_MinTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_MinTextArea.getTextArea(),
                        _BackButton.getButton(), 6f);
    }

    private void initMaxTextArea() {
        addComponent(_MaxTextArea.getTextArea());
        _MaxTextArea.centerAllign(true);

        ((LayeredLayout) _MaxTextArea.getTextArea().getParent().getLayout()).
                setInsets(_MaxTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_MaxTextArea.getTextArea(),
                        _BackButton.getButton(), 7f);
    }

    private void onBackButton() {
        _PreviousForm.showBack();
    }

    private void onConfirmButton() {
        _Data.changePrompt(_OriginalPrompt, _NewPrompt);
        _PreviousForm.showBack();
    }

    private void onNameTextArea() {
        _NewPrompt.setName(_NameTextArea.getText());
        //TODO: check if empty
    }

    private void onPromptTextArea() {
        _NewPrompt.setPrompt(_PromptTextArea.getText());
        //TODO:: check if empty
    }

    private void onResponseTextArea() {
        switch (_ResponseTextArea.getText()) {
            case "slider": _NewPrompt.setDataType(PromptDataType.INT); break;
            case "yes/no": _NewPrompt.setDataType(PromptDataType.BOOL); break;
            case "number": _NewPrompt.setDataType(PromptDataType.DOUBLE); break;
            case "words": _NewPrompt.setDataType(PromptDataType.STRING); break;
            default : break; //TODO: throw warning if input is wrong
        }
    }

    private void onMinTextArea() {
        _NewPrompt.setMin(Integer.parseInt(_MinTextArea.getText()));
        //TODO: check for valid input
    }

    private void onMaxTextArea() {
        _NewPrompt.setMin(Integer.parseInt(_MaxTextArea.getText()));
        //TODO: check for valid input
    }


    class EditPromptCallback implements ActionListener {

        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            String sourceName = evt.getComponent().getName();

            if (sourceName.equals(_BackButton.getName())) {
                onBackButton();
            } else if (sourceName.equals(_ConfirmButton.getName())) {
                onConfirmButton();
            } else if (sourceName.equals(_NameTextArea.getName())) {
                onNameTextArea();
            } else if (sourceName.equals(_PromptTextArea.getName())) {
                onPromptTextArea();
            } else if (sourceName.equals(_ResponseTextArea.getName())) {
                onResponseTextArea();
            } else if (sourceName.equals(_MinTextArea.getName())) {
                onMinTextArea();
            } else if (sourceName.equals(_MaxTextArea.getName())) {
                onMaxTextArea();
            }
        }
    }
}
