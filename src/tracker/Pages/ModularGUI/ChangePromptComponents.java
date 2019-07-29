package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.PromptDataType;
import tracker.GuiComponents.Individual.GuiTextArea;

import static tracker.Data.Prompts.PromptDataType.*;

public class ChangePromptComponents extends DefaultPageComponents {

    private MentalPrompt _CurrPrompt;
    private MentalPrompt _NewPrompt;

    private GuiTextArea _NameTextArea;
    private GuiTextArea _PromptTextArea;
    private GuiTextArea _ResponseTextArea;
    private GuiTextArea _MinTextArea;
    private GuiTextArea _MaxTextArea;

    public ChangePromptComponents(
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
        initInputFields();
        createInputFields();
    }

    private void createDefaultComponents() {
        initDefault();
        initConfirmButton();
        createComponents();
    }

    private void initInputFields() {
        ChangePromptCallback callback = new ChangePromptCallback();

        _NameTextArea = new GuiTextArea("Name", getResources());
        _NameTextArea.setHint("Question Title");
        _NameTextArea.setActionListener(callback);

        _PromptTextArea = new GuiTextArea("Prompt", getResources());
        _PromptTextArea.setHint("Prompt goes here");
        _PromptTextArea.setActionListener(callback);

        _ResponseTextArea = new GuiTextArea("Type", getResources());
        _ResponseTextArea.setHint("slider, yes/no, number, words");
        _ResponseTextArea.setActionListener(callback);

        _MinTextArea = new GuiTextArea("Min", getResources());
        _MinTextArea.setHint("Min (for slider/number)");
        _MinTextArea.setActionListener(callback);

        _MaxTextArea = new GuiTextArea("Max", getResources());
        _MaxTextArea.setHint("Max (for slider/number)");
        _MaxTextArea.setActionListener(callback);

    }

    protected void setTextAreas() {
        if (_CurrPrompt == null) {
            return;
        }

        _NameTextArea.setText(_CurrPrompt.getName());
        _PromptTextArea.setText(_CurrPrompt.getPrompt());
        _ResponseTextArea.setText(getTextFromAnswer());
        _MinTextArea.setText(Integer.toString(_CurrPrompt.getMin()));
        _MaxTextArea.setText(Integer.toString(_CurrPrompt.getMax()));
    }

    private void createInputFields() {
        initNameTextArea();
        initPromptTextArea();
        initResponseTextArea();
        initMinTextArea();
        initMaxTextArea();
    }

    private String getTextFromAnswer() {
        String text;
        switch (_CurrPrompt.getDataType()) {
            case INT: text = "slider"; break;
            case BOOL: text = "yes/no"; break;
            case DOUBLE: text = "number"; break;
            case STRING: text = "words"; break;
            default : text = "";break;
        }
        return text;
    }


    private void initNameTextArea() {
        addComponent(_NameTextArea.getTextArea());
        _NameTextArea.centerAllign(true);

        ((LayeredLayout) _NameTextArea.getTextArea().getParent().getLayout()).
                setInsets(_NameTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_NameTextArea.getTextArea(),
                        getBackButton().getButton(), 3f);
    }

    private void initPromptTextArea() {
        addComponent(_PromptTextArea.getTextArea());
        _PromptTextArea.centerAllign(true);

        ((LayeredLayout) _PromptTextArea.getTextArea().getParent().getLayout()).
                setInsets(_PromptTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_PromptTextArea.getTextArea(),
                        getBackButton().getButton(), 4f);
    }

    private void initResponseTextArea() {
        addComponent(_ResponseTextArea.getTextArea());
        _ResponseTextArea.centerAllign(true);

        ((LayeredLayout) _ResponseTextArea.getTextArea().getParent().getLayout()).
                setInsets(_ResponseTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_ResponseTextArea.getTextArea(),
                        getBackButton().getButton(), 5f);
    }

    private void initMinTextArea() {
        addComponent(_MinTextArea.getTextArea());
        _MinTextArea.centerAllign(true);

        ((LayeredLayout) _MinTextArea.getTextArea().getParent().getLayout()).
                setInsets(_MinTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_MinTextArea.getTextArea(),
                        getBackButton().getButton(), 6f);
    }

    private void initMaxTextArea() {
        addComponent(_MaxTextArea.getTextArea());
        _MaxTextArea.centerAllign(true);

        ((LayeredLayout) _MaxTextArea.getTextArea().getParent().getLayout()).
                setInsets(_MaxTextArea.getTextArea(), "0 10% auto 5%").
                setReferenceComponentTop(_MaxTextArea.getTextArea(),
                        getBackButton().getButton(), 7f);
    }

    @Override
    protected void onConfirmButton() {

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
            case "slider": _NewPrompt.setDataType(INT); break;
            case "yes/no": _NewPrompt.setDataType(BOOL); break;
            case "number": _NewPrompt.setDataType(DOUBLE); break;
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
            } else if (sourceName.equals(_ResponseTextArea.getName())) {
                onResponseTextArea();
            } else if (sourceName.equals(_MinTextArea.getName())) {
                onMinTextArea();
            } else if (sourceName.equals(_MaxTextArea.getName())) {
                onMaxTextArea();
            }
        }
    }

    protected MentalPrompt getTargetPrompt() {
        return _CurrPrompt;
    }

    protected MentalPrompt getNewPrompt() {
        return _NewPrompt;
    }

}
