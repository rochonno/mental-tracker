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

public class PromptEditDelete extends PromptListComponent {

    private java.awt.event.ActionListener _NotifyChange;

    public PromptEditDelete(
            Form parentPage,
            final MentalPrompt prompt,
            Resources resources,
            final java.awt.event.ActionListener callback) {

        super(parentPage, prompt, resources);
        _NotifyChange = callback;
    }

    private GuiButton _RemoveButton;
    private GuiButton _EditButton;

    public void initialize(final float location, final Component refComponent) {
        initializeDefault(location, refComponent);

        EditDeleteCallback callback = new EditDeleteCallback();

        _RemoveButton = new GuiButton(
                "DeleteButton",
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
                new java.awt.event.ActionEvent(this, 0, "DeletePrompt"));
    }

    private void onEditButton() {
        _EditButton.setSelected(false);
        _NotifyChange.actionPerformed(
                new java.awt.event.ActionEvent(this, 0, "EditPrompt"));
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
        public void actionPerformed(ActionEvent evt) {
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
        Component.setSameSize(_RemoveButton.getButton(), _EditButton.getButton());

        ((LayeredLayout) _RemoveButton.getButton().getParent().getLayout()).
                setInsets(_RemoveButton.getButton(),"0 auto auto 0").
                setReferenceComponentLeft(_RemoveButton.getButton(), getTitle().getLabel(), 1.1F).
                setReferenceComponentTop(_RemoveButton.getButton(), getTitle().getLabel(), 0);
    }

    private void initEditButton() {
        getParentPage().addComponent(_EditButton.getButton());

        ((LayeredLayout) _EditButton.getButton().getParent().getLayout()).
                setInsets(_EditButton.getButton(),"0 auto auto 0").
                setReferenceComponentLeft(_EditButton.getButton(), _RemoveButton.getButton(), 1).
                setReferenceComponentTop(_EditButton.getButton(), _RemoveButton.getButton(), 0);
    }
}
