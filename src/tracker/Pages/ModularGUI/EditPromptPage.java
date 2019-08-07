package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;

/******************************************************************************
 * Creates a page for editing prompt.
 * Child class of ChangePromptComponents.
 *      Adds to this by taking an initial prompt and Changing it accordingly
 ******************************************************************************/
public class EditPromptPage extends ChangePromptComponents {

    /**
     * Constructor for the page for editing a prompt.
     *
     * @param data the instance data containing all prompts and answers;
     * @param previous the previous Form.
     * @param target the MentalPrompt to be edited
     */
    EditPromptPage(
            final InstanceData data,
            final Form previous,
            final MentalPrompt target) {

        super(data, previous, target, "EditPrompt");

        setTextAreas();
    }

    /**
     * Invoked when the confirm/next button is pressed.
     * Changes out the current prompt using what the user entered.
     */
    @Override
    protected void onConfirmButton() {
        getData().changePrompt(getTargetPrompt(), getNewPrompt());
        Form promptList = new
                PromptListPage(getData(), new MainPage(getData()));
        promptList.showBack();
    }

}
