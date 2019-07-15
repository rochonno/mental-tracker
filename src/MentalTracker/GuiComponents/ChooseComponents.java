package MentalTracker.GuiComponents;

import MentalTracker.DataPortions.Prompts.MentalPrompt;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Button;
import com.codename1.ui.Slider;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;

public class ChooseComponents {

    private MentalPrompt _Prompt;
    public Label PromptTitle;
    public Label PromptQuestion;

    public Button ConfirmButton;
    public Button BackButton;

    public Slider InputSlider;
    public RadioButton InputButtonYes;
    public RadioButton InputButtonNo;
    public TextArea InputTextField;

    public ChooseComponents (MentalPrompt prompt)
    {
        _Prompt = prompt;

        TurnComponentsOn();
    }

    private void TurnComponentsOn()
    {
        createPromptQuestion();
        createPromptTitle();
        PromptTitle = new com.codename1.ui.Label();

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
    }

    private void createPromptQuestion()
    {
        PromptQuestion = new Label();
        PromptQuestion.setText(_Prompt.get_Prompt());
    }

    private void createSlider()
    {
        InputSlider = new Slider();
        InputSlider.setMaxValue(_Prompt.GetMax());
        InputSlider.setMinValue(_Prompt.GetMin());
    }

    private void createTextArea()
    {
        InputTextField = new TextArea();
    }

    private void createYesNo()
    {
        InputButtonNo = new RadioButton();
        InputButtonYes = new RadioButton();
    }


    public boolean CheckSlider ()
    {
        if(InputSlider == null) return false;
        return true;
    }

    public boolean InputButtons ()
    {
        if(InputButtonNo == null) return false;
        return true;
    }

    public boolean TextArea ()
    {
        if(InputTextField == null) return false;
        return true;
    }
}
