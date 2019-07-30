package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.InstanceData;
import tracker.GuiComponents.ImageNames;
import tracker.GuiComponents.Individual.GuiButton;
import tracker.GuiComponents.Individual.GuiLabel;

/******************************************************************************
 * Parent class that holds/controls the default components used by every Page.
 * Creates a top inset and back button.
 *      Confirm/Next button must be created by calling the appropriate functions
 *
 *  Functions to call for no Confirm button:
 *          initDefault(), createComponents()
 *  For Confirm button as well:
 *          initDefault(), initConfirmButton(), createComponents()
 ******************************************************************************/
class DefaultPageComponents extends Form {

    /** The previous Page. */
    private Form _PreviousForm;
    /** Current Resource Instance. */
    private Resources _ResourceInstance;

    /** Data of the current instance (prompts and answers). */
    private InstanceData _Data;


    /**
     * Constructor for the DefaultComponents class.
     * @param data instance data
     * @param previous previous page
     * @param pageName name of the current page
     */
    DefaultPageComponents(final InstanceData data, Form previous, final String pageName) {
        _Data = data;
        _PreviousForm = previous;
        _ResourceInstance = Resources.getGlobalResources();

        initializeLayout(pageName);
    }

    /** Default TopInset. */
    private GuiLabel _TopInset;
    /** Default BackButton. */
    private GuiButton _BackButton;
    /** Confirm Button. Need to initialize before use. */
    private GuiButton _ConfirmButton;


    /**
     * Initializes the Layered Layout.
     * @param pageName name of the current page
     */
    private void initializeLayout(final String pageName) {
        setLayout(new LayeredLayout());
        setInlineStylesTheme(_ResourceInstance);
        setScrollableY(false);
        setInlineStylesTheme(_ResourceInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Mental Tracker");
        setName(pageName);
    }

    /**
     * Sets the page to be scrollable vertically.
     */
    void setIsScrollable() {
        setScrollableY(true);
    }

    /**
     * Initializes the default components. No Confirm button.
     */
    void initDefault() {
        initTopInset();
        initBackButton();
    }

    private void initTopInset() {
        _TopInset = new GuiLabel("TopInset", _ResourceInstance);
    }

    private void initBackButton() {
        _BackButton = new GuiButton(
                ImageNames.BACK_UNSELECT,
                _ResourceInstance,
                ImageNames.BACK_UNSELECT,
                ImageNames.BACK_SELECT
        );
        _BackButton.setActionListener(new DefaultButtonListener());
    }

    /**
     * Initialized the confirm button. Need before calling createComponents().
     */
    void initConfirmButton() {
        _ConfirmButton = new GuiButton(
                ImageNames.CONTINUE_UNSELECT,
                _ResourceInstance,
                ImageNames.CONTINUE_UNSELECT,
                ImageNames.CONTINUE_SELECT

        );
        _ConfirmButton.setActionListener(new DefaultButtonListener());
    }

    /**
     * Creates the default components in the Layered Layout.
     */
    void createComponents() {
        if (_TopInset == null) {
            return;
        }
        createTopInset();
        createBackButton();
        if (_ConfirmButton != null) {
            createConfirmButton();
        }
    }

    private void createTopInset() {
        _TopInset.setSizeStr("inherit 4.2328043mm");
        _TopInset.getLabel();
        addComponent(_TopInset.getLabel());

        ((LayeredLayout) _TopInset.getLabel().
                getParent().getLayout()).setInsets(
                _TopInset.getLabel(),
                "1.6mm 5.0mm auto 5.0mm").
                setReferenceComponents(
                        _TopInset.getLabel(), "-1 -1 -1 -1").
                setReferencePositions(
                        _TopInset.getLabel(), "0.0 0.0 0.0 0.0");
    }

    private void createBackButton() {
        _BackButton.setSizeStr("20.042328mm 10.8465605mm");
        addComponent(_BackButton.getButton());

        ((LayeredLayout) _BackButton.getButton().
                getParent().getLayout()).setInsets(
                _BackButton.getButton(),
                "0.5mm auto auto 0.0mm").
                setReferenceComponents(
                        _BackButton.getButton(), "0 -1 -1 0 ").
                setReferencePositions(
                        _BackButton.getButton(), "-1 0.0 0.0 0.0");
    }

    private void createConfirmButton() {
        _ConfirmButton.setSizeStr("116.93122mm 23.544973mm");
        addComponent(_ConfirmButton.getButton());

        ((LayeredLayout) _ConfirmButton.getButton().
                getParent().getLayout()).setInsets(
                _ConfirmButton.getButton(),
                "auto -125% 0 auto");
    }

    /**
     * Called when the back button is pressed.
     */
    private void onBackButton() {
        _PreviousForm.showBack();
    }

    /**
     * Needs to be overridden for functionality.
     * Function changes based on current page.
     */
    void onConfirmButton() {
        
    }

    /**
     * Action Listener class for the default components.
     */
    class DefaultButtonListener implements ActionListener {

        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(final ActionEvent evt) {
            String compName = evt.getComponent().getName();

            if (compName.equals(_BackButton.getName())) {
                onBackButton();
            } else if (compName.equals(_ConfirmButton.getName())) {
                onConfirmButton();
            }
        }
    }

    InstanceData getData() {
        return _Data;
    }

    Form getPreviousForm() {
        return _PreviousForm;
    }

    GuiLabel getTopInset() {
        return _TopInset;
    }

    GuiButton getBackButton() {
        return _BackButton;
    }

    Resources getResources() {
        return _ResourceInstance;
    }
}
