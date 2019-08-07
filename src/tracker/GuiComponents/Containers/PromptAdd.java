package tracker.GuiComponents.Containers;

import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.Prompts.MentalPrompt;
import tracker.GuiComponents.ImageNames;
import tracker.GuiComponents.Individual.GuiButton;

public class PromptAdd extends PromptListComponent {

    /** ActionListener to invoke when the button is pressed. */
    private ActionListener _NotifyChange;

    public PromptAdd(
            final Form parentPage,
            final MentalPrompt prompt,
            final Resources resources,
            final ActionListener callback) {

        super(parentPage, prompt, resources);
        _NotifyChange = callback;
    }

    /** Button to add a prompt. */
    private GuiButton _AddButton;

    public void initialize(final float location, final Component refComponent) {
        initializeDefault(location, refComponent);

        _AddButton = new GuiButton(
                "AddButton",
                getResources(),
                ImageNames.ADD_PLUS,
                ImageNames.ADD_PLUS
                );

        _AddButton.setActionListener(new AddEventCallback());

        initAddButton();
    }

    private void onAddButton() {
        _NotifyChange.actionPerformed(new ActionEvent(this, 0));
    }

    class AddEventCallback implements com.codename1.ui.events.ActionListener {
        AddEventCallback() {
        }


        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(final ActionEvent evt) {
            String sourceName = evt.getComponent().getName();

            if (sourceName.equals(_AddButton.getName())) {
                onAddButton();
            }
        }
    }

    private void initAddButton() {
        getParentPage().addComponent(_AddButton.getButton());
        _AddButton.getButton().setShouldCalcPreferredSize(true);

        ((LayeredLayout) _AddButton.getButton().getParent().getLayout()).
                setInsets(_AddButton.getButton(), "0 auto auto 0").
                setReferenceComponentLeft(
                        _AddButton.getButton(), getTitle().getLabel(), 1.1F).
                setReferenceComponentTop(
                        _AddButton.getButton(), getTitle().getLabel(), 0);
    }

}
