package MentalTracker.ComponentGenerators;

import com.codename1.components.ImageViewer;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;

import java.io.IOException;

public class MainPageComponents {
    public Label TopInset;
    public Label PromptTitle;
    public ImageViewer MentalTrackLogo;
    public Button StartQuestions;

    public MainPageComponents()
    {
        turnComponentsOn();
    }

    private void turnComponentsOn()
    {
        TopInset = new Label();
        PromptTitle = new Label();
        StartQuestions = new RadioButton();
        MentalTrackLogo = new ImageViewer();

    }
}
