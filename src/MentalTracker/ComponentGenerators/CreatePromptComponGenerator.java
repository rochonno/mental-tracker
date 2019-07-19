package MentalTracker.ComponentGenerators;

import com.codename1.ui.Button;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;

public class CreatePromptComponGenerator {

    public Label TopInsert;
    public Label Prompt;

    public Button CreateButton;
    public Button BackButton;

    public TextArea InputNameTextArea;
    public TextArea InputPromptTextArea;
    public TextArea InputResponseTextArea;
    public TextArea InputMinTextArea;
    public TextArea InputMaxTextArea;

    public CreatePromptComponGenerator ()
    {
        turnComponentsOn();
    }

    private void turnComponentsOn()
    {
        createUiComponents();
        createInputFields();
    }

    private void createUiComponents()
    {
        TopInsert = new Label();
        Prompt = new Label();
        Prompt.setText("Question Creation");

        CreateButton = new RadioButton();
        BackButton = new RadioButton();
    }

    private void createInputFields()
    {
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
