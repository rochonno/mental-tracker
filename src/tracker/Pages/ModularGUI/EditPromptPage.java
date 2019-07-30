package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;

public class EditPromptPage extends ChangePromptComponents {


    public EditPromptPage(InstanceData data, Form previous, MentalPrompt target) {
        super(data, previous, target, "EditPrompt");

        setTextAreas();
    }

    @Override
    protected void onConfirmButton() {
        getData().changePrompt(getTargetPrompt(), getNewPrompt());
        Form promptList = new PromptListPage(getData(), new MainPage(getData()));
        promptList.showBack();
    }

}
