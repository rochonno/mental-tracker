package tracker.Pages.ModularGUI;

import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.MentalPrompts;
import tracker.Data.Prompts.PromptDataType;
import tracker.ComponentGenerators.CreatePromptComponGenerator;
import tracker.MentalExceptions.SaveFileException;
import com.codename1.io.Log;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import static com.codename1.ui.util.Resources.getGlobalResources;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Creates a page for creating a custom user defined prompt.
 ******************************************************************************/
public class CreatePromptPage extends ChangePromptComponents {


    public CreatePromptPage(InstanceData data, Form previous) {
        super(data, previous, null, "Create Prompt");
    }

    @Override
    protected void onConfirmButton() {
        getData().addPrompt(getNewPrompt());
        Form promptList = new PromptList(getData(), new MainPage(getData()));
    }
}
