package tracker.GuiComponents.Containers;

import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.Prompts.MentalPrompt;
import tracker.GuiComponents.Individual.GuiButton;
import tracker.GuiComponents.ImageNames;

/**
 * Gui components for a prompt and the edit/delete buttons.
 */
public class PromptEditDelete extends PromptListComponent {

    /** ActionListener to invoke when a button is pressed. */
    private ActionListener _NotifyChange;

    public PromptEditDelete(
            final Form parentPage,
            final MentalPrompt prompt,
            final Resources resources,
            final ActionListener callback) {

        super(parentPage, prompt, resources);
        _NotifyChange = callback;
    }

    /** Button to remove the current prompt. */
    private GuiButton _RemoveButton;
    /** Button to edit the current prompt. */
    private GuiButton _EditButton;

    public void initialize(final float location, final Component refComponent) {
        initializeDefault(location, refComponent);

        EditDeleteCallback callback = new EditDeleteCallback();

        _RemoveButton = new GuiButton(
                "RemoveButton",
                getResources(),
                ImageNames.DELETE_X,
                ImageNames.DELETE_X
                );
        _EditButton = new GuiButton(
                "EditButton",
                getResources(),
                ImageNames.EDIT_PENCIL,
                ImageNames.EDIT_PENCIL
                );

        _RemoveButton.setActionListener(callback);
        _EditButton.setActionListener(callback);

        initRemoveButton();
        initEditButton();
    }

    private void onRemoveButton() {
        _RemoveButton.setSelected(false);
        _NotifyChange.actionPerformed(
                new ActionEvent(this, 0));
    }

    private void onEditButton() {
        _EditButton.setSelected(false);
        _NotifyChange.actionPerformed(
                new ActionEvent(this, 1));
    }

    class EditDeleteCallback implements  ActionListener {
        EditDeleteCallback() {
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

            if (sourceName.equals(_RemoveButton.getName())) {
                onRemoveButton();
            } else if (sourceName.equals(_EditButton.getName())) {
                onEditButton();
            }
        }
    }

    private void initRemoveButton() {
        getParentPage().addComponent(_RemoveButton.getButton());
        _RemoveButton.getButton().setShouldCalcPreferredSize(true);
        Component.setSameSize(
                _RemoveButton.getButton(),
                _EditButton.getButton()
        );

        ((LayeredLayout) _RemoveButton.getButton().getParent().getLayout()).
                setInsets(_RemoveButton.getButton(), "0 auto auto 0").
                setReferenceComponentLeft(
                        _RemoveButton.getButton(), getTitle().getLabel(), 1.1F).
                setReferenceComponentTop(
                        _RemoveButton.getButton(), getTitle().getLabel(), 0);
    }

    private void initEditButton() {
        getParentPage().addComponent(_EditButton.getButton());

        ((LayeredLayout) _EditButton.getButton().getParent().getLayout()).
                setInsets(_EditButton.getButton(), "0 auto auto 0").
                setReferenceComponentLeft(
                        _EditButton.getButton(), _RemoveButton.getButton(), 1).
                setReferenceComponentTop(
                        _EditButton.getButton(), _RemoveButton.getButton(), 0);
    }

    public String getEditName() {
        return _EditButton.getName();
    }

    public String getRemoveName() {
        return _RemoveButton.getName();
    }
}
