package tracker.GuiComponents.Containers;

import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.Prompts.MentalPrompt;
import tracker.GuiComponents.Individual.GuiLabel;

public class PromptListComponent {

    private Form _Page;
    private MentalPrompt _CurrPrompt;
    private Resources _Resources;

    PromptListComponent(
            Form parentPage,
            final MentalPrompt prompt,
            Resources resources) {

        _Page = parentPage;
        _Resources = resources;
        _CurrPrompt = prompt;
    }

    private float _Location;
    private Component _RefComponent;

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
                setReferenceComponentTop(_Title.getLabel(), _RefComponent, _Location);
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
