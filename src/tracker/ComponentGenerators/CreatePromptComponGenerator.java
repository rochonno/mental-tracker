package tracker.ComponentGenerators;

import com.codename1.ui.Button;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Generates the components needed for the custom prompt creation page.
 ******************************************************************************/
public class CreatePromptComponGenerator {

    /** Top Inset for spacing on the page. */
    public Label TopInset;
    /** Displays the name of the current page. */
    public Label Prompt;

    /** Button to confirm the creation of the Prompt. */
    public Button CreateButton;
    /** Button to return to the previous page. */
    public Button BackButton;

    /** Text Box for user input. */
    public TextArea InputNameTextArea;
    /** Text Box for user input. */
    public TextArea InputPromptTextArea;
    /** Text Box for user input. */
    public TextArea InputResponseTextArea;
    /** Text Box for user input. */
    public TextArea InputMinTextArea;
    /** Text Box for user input. */
    public TextArea InputMaxTextArea;

    public CreatePromptComponGenerator() {
        turnComponentsOn();
    }

    private void turnComponentsOn() {
        createUiComponents();
        createInputFields();
    }

    private void createUiComponents() {
        TopInset = new Label();
        Prompt = new Label();
        Prompt.setText("Question Creation");

        CreateButton = new RadioButton();
        BackButton = new RadioButton();
    }

    private void createInputFields() {
        InputNameTextArea = new TextArea();
        InputNameTextArea.setHint("Question Title");

        InputPromptTextArea = new TextArea();
        InputPromptTextArea.setHint("Prompt goes here");

        InputResponseTextArea = new TextArea();
        InputResponseTextArea.setHint("slider, yes/no, number, words");

        InputMinTextArea = new TextArea();
        InputMinTextArea.setHint("Min (for slider/number)");

        InputMaxTextArea = new TextArea();
        InputMaxTextArea.setHint("Max (for slider/number)");
    }
}
