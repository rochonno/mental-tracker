package tracker.Pages.ModularGUI;

import tracker.Data.InstanceData;
import com.codename1.ui.Form;

/******************************************************************************
 * Creates a page for creating a custom user defined prompt.
 * Child class of ChangePromptComponents.
 *      Adds to this by adding a new prompt onto the InstanceData list.
 ******************************************************************************/
public class CreatePromptPage extends ChangePromptComponents {

    /**
     * Constructor for the page for making a new prompt.
     *
     * @param data the instance data containing all prompts and answers;
     * @param previous the previous Form.
     */
    CreatePromptPage(final InstanceData data, final Form previous) {
        super(data, previous, null, "Create Prompt");
    }

    /**
     * Invoked when the confirm/next button is pressed.
     * Adds a new prompt based on user input.
     */
    @Override
    protected void onConfirmButton() {
        getData().addPrompt(getNewPrompt());
        Form promptList =
                new PromptListPage(getData(), new MainPage(getData()));
        promptList.showBack();
    }
}
