package tracker.ComponentGenerators;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Generates the components needed for the Main Page
 ******************************************************************************/
public class MainPageComponents {
    /** Top Inset for spacing of the page. */
    public Label TopInset;
    /** Displays the name of the current page. */
    public Label PromptTitle;

    /** Displays the App Logo. */
    public ImageViewer MentalTrackLogo;
    /** Button to start the daily questionnaire. */
    public Button StartQuestions;

    public MainPageComponents() {
        turnComponentsOn();
    }

    private void turnComponentsOn() {
        TopInset = new Label();
        PromptTitle = new Label();
        StartQuestions = new RadioButton();
        MentalTrackLogo = new ImageViewer();
    }
}
