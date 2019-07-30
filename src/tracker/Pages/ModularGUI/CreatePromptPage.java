package tracker.Pages.ModularGUI;

import tracker.Data.InstanceData;
import com.codename1.ui.Form;

/******************************************************************************
 * Creates a page for creating a custom user defined prompt.
 * Child class of ChangePromptComponents.
 *      Adds to this by taking an initial prompt and
 *      adding a new prompt
 ******************************************************************************/
public class CreatePromptPage extends ChangePromptComponents {


    public CreatePromptPage(InstanceData data, Form previous) {
        super(data, previous, null, "Create Prompt");
    }

    /**
     * Invoked when the confirm/next button is pressed.
     *      Overridden to provide functionality specific
     *      for this class
     */
    @Override
    protected void onConfirmButton() {
        getData().addPrompt(getNewPrompt());
        Form promptList = new PromptListPage(getData(), new MainPage(getData()));
        promptList.showBack();
    }
}
