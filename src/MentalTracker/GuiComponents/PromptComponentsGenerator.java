package MentalTracker.GuiComponents;

import MentalTracker.DataPortions.Prompts.MentalPrompt;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Button;
import com.codename1.ui.Slider;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;

import java.util.List;
import java.util.Vector;

public class PromptComponentsGenerator {
    private MentalPrompt _Prompt;

    public Label TopInset;
    public Label PromptTitle;
    public Label PromptQuestion;

    public Button AdvanceButton;
    public Button BackButton;

    public Slider InputSlider;
    public RadioButton InputButtonYes;
    public RadioButton InputButtonNo;
    public TextArea InputTextArea;

    public List<ComponantName> EnabledComponents = new Vector<>();

    public PromptComponentsGenerator(MentalPrompt prompt)
    {
        _Prompt = prompt;

        turnComponentsOn();
    }

    private void turnComponentsOn()
    {
        TopInset = new Label();
        EnabledComponents.add(ComponantName.TOP_INSET);
        createPromptQuestion();
        createPromptTitle();
        createBackNextButton();

        switch (_Prompt.GetDataType()){
            case INT: createSlider(); break;
            case STRING: createTextArea(); break;
            case BOOL: createYesNo(); break;
            case DOUBLE: createTextArea(); break;
        }
    }

    private void createPromptTitle()
    {
        PromptTitle = new Label();
        PromptTitle.setText(_Prompt.get_Name());
        EnabledComponents.add(ComponantName.PROMPT_TITLE);
    }

    private void createPromptQuestion()
    {
        PromptQuestion = new Label();
        PromptQuestion.setText(_Prompt.get_Prompt());
        EnabledComponents.add(ComponantName.PROMPT_QUESTION);
    }

    private void createBackNextButton()
    {
        AdvanceButton = new RadioButton();
        BackButton = new RadioButton();
        EnabledComponents.add(ComponantName.ADV_BUTTON);
        EnabledComponents.add(ComponantName.BACK_BUTTON);
    }

    private void createSlider()
    {
        InputSlider = new Slider();
        EnabledComponents.add(ComponantName.INPUT_SLIDER);
        InputSlider.setMaxValue(_Prompt.GetMax());
        InputSlider.setMinValue(_Prompt.GetMin());
    }

    private void createTextArea()
    {
        InputTextArea = new TextArea();
        EnabledComponents.add(ComponantName.INPUT_TEXT_AREA);
    }

    private void createYesNo()
    {
        InputButtonNo = new RadioButton();
        EnabledComponents.add(ComponantName.INPUT_BUTTON_NO);
        InputButtonYes = new RadioButton();
        EnabledComponents.add(ComponantName.INPUT_BUTTON_YES);
    }

    public boolean CheckSlider ()
    {
        if(InputSlider == null) return false;
        return true;
    }

    public boolean CheckInputButtons ()
    {
        if(InputButtonNo == null) return false;
        return true;
    }

    public boolean CheckTextArea ()
    {
        if(InputTextArea == null) return false;
        return true;
    }
}
