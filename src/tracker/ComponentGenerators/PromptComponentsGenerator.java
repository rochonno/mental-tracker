/******************************************************************************
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * Generates the components needed for a single prompt.
 ******************************************************************************/
package tracker.ComponentGenerators;

import tracker.Data.Prompts.MentalPrompt;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Button;
import com.codename1.ui.Slider;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;

import java.util.List;
import java.util.Vector;

public class PromptComponentsGenerator {
    /** The Prompt that the components are being created for. */
    private MentalPrompt _Prompt;

    /** Top Inset for spacing on the page. */
    public Label TopInset;
    /** Displays the name of the current Prompt. */
    public Label PromptTitle;
    /** Displays the question of the current Prompt. */
    public Label PromptQuestion;

    /** Button to advance to the next Prompt. */
    public Button AdvanceButton;
    /** Button to return to the previous page. */
    public Button BackButton;

    /** Slider for input. */
    public Slider InputSlider;
    /** Yes button for input. */
    public RadioButton InputButtonYes;
    /** No Button for input. */
    public RadioButton InputButtonNo;
    /** Text Area for input. */
    public TextArea InputTextArea;

    /** List of generated components for the page. */
    public List<ComponentName> EnabledComponents = new Vector<>();

    public PromptComponentsGenerator(final MentalPrompt prompt) {
        _Prompt = prompt;

        turnComponentsOn();
    }

    private void turnComponentsOn() {
        TopInset = new Label();
        EnabledComponents.add(ComponentName.TOP_INSET);
        createPromptQuestion();
        createPromptTitle();
        createBackNextButton();

        switch (_Prompt.getDataType()) {
            case INT: createSlider(); break;
            case STRING: createTextArea(); break;
            case BOOL: createYesNo(); break;
            case DOUBLE: createTextArea(); break;
            default: break; //TODO: add new exception type
        }
    }

    private void createPromptTitle() {
        PromptTitle = new Label();
        PromptTitle.setText(_Prompt.getName());
        EnabledComponents.add(ComponentName.PROMPT_TITLE);
    }

    private void createPromptQuestion() {
        PromptQuestion = new Label();
        PromptQuestion.setText(_Prompt.getPrompt());
        EnabledComponents.add(ComponentName.PROMPT_QUESTION);
    }

    private void createBackNextButton() {
        AdvanceButton = new RadioButton();
        BackButton = new RadioButton();
        EnabledComponents.add(ComponentName.ADV_BUTTON);
        EnabledComponents.add(ComponentName.BACK_BUTTON);
    }

    private void createSlider() {
        InputSlider = new Slider();
        EnabledComponents.add(ComponentName.INPUT_SLIDER);
        InputSlider.setMaxValue(_Prompt.getMax());
        InputSlider.setMinValue(_Prompt.getMin());
    }

    private void createTextArea() {
        InputTextArea = new TextArea();
        EnabledComponents.add(ComponentName.INPUT_TEXT_AREA);
    }

    private void createYesNo() {
        InputButtonNo = new RadioButton();
        EnabledComponents.add(ComponentName.INPUT_BUTTON_NO);
        InputButtonYes = new RadioButton();
        EnabledComponents.add(ComponentName.INPUT_BUTTON_YES);
    }

    public boolean checkSlider() {
        if (InputSlider == null) {
            return false;
        }
        return true;
    }

    public boolean checkInputButtons() {
        if (InputButtonNo == null) {
            return false;
        }
        return true;
    }

    public boolean checkTextArea() {
        if (InputTextArea == null) {
            return false;
        }
        return true;
    }
}
