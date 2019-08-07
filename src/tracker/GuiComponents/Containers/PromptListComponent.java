package tracker.GuiComponents.Containers;

import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.Prompts.MentalPrompt;
import tracker.GuiComponents.Individual.GuiLabel;

/**
 * Single prompt for the list of prompts in the Gui page.
 */
public class PromptListComponent {

    /** Page that this will be displayed on. */
    private Form _Page;
    /** MentalPrompt this is displaying. */
    private MentalPrompt _CurrPrompt;
    /** Current Resource instance. */
    private Resources _Resources;

    PromptListComponent(
            final Form parentPage,
            final MentalPrompt prompt,
            final Resources resources) {

        _Page = parentPage;
        _Resources = resources;
        _CurrPrompt = prompt;
    }

    /** Position down the page to space out evenly. */
    private float _Location;

    /** Reference component to space this off of.
     *      (Back Button is recommended)
     */
    private Component _RefComponent;

    /** Title of the prompt being displayed. */
    private GuiLabel _Title;

    void initializeDefault(final float location, final Component refComponent) {
        _RefComponent = refComponent;
        _Location = location;
        _Title = new GuiLabel("PromptName", _Resources);
        initTitle();
    }

    private void initTitle() {
        _Title.setText(_CurrPrompt.getName());
        _Page.addComponent(_Title.getLabel());
        _Title.getLabel().setPreferredSizeStr("40mm 5mm");

        ((LayeredLayout) _Title.getLabel().getParent().getLayout()).
                setInsets(_Title.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(
                        _Title.getLabel(), _RefComponent, _Location);
    }

    Form getParentPage() {
        return _Page;
    }

    GuiLabel getTitle() {
        return _Title;
    }

    Resources getResources() {
        return _Resources;
    }

    public MentalPrompt getPrompt() {
        return _CurrPrompt;
    }
}
