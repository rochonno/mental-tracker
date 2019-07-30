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

public class DefaultPageComponents extends Form {

    private Form _PreviousForm;
    private Resources _ResourceInstance;

    private InstanceData _Data;

    private GuiLabel _TopInset;
    private GuiButton _BackButton;
    private GuiButton _ConfirmButton;

    private DefaultButtonListener _Callback;

    public DefaultPageComponents(final InstanceData data, Form previous, final String pageName) {
        _Data = data;
        _PreviousForm = previous;
        _ResourceInstance = Resources.getGlobalResources();

        initializeLayout(pageName);
    }

    private void initializeLayout(final String pageName) {
        setLayout(new LayeredLayout());
        setInlineStylesTheme(_ResourceInstance);
        setScrollableY(false);
        setInlineStylesTheme(_ResourceInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Mental Tracker");
        setName(pageName);
    }

    protected void setIsScrollable() {
        setScrollableY(true);
    }

    protected void initDefault() {
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

    protected void initConfirmButton() {
        _ConfirmButton = new GuiButton(
                ImageNames.CONTINUE_UNSELECT,
                _ResourceInstance,
                ImageNames.CONTINUE_UNSELECT,
                ImageNames.CONTINUE_SELECT

        );
        _ConfirmButton.setActionListener(new DefaultButtonListener());
    }

    protected void createComponents() {
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

    private void onBackButton() {
        _PreviousForm.showBack();
    }

    protected void onConfirmButton() {
        
    }

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

    protected InstanceData getData() {
        return _Data;
    }

    protected Form getPreviousForm() {
        return _PreviousForm;
    }

    protected GuiLabel getTopInset() {
        return _TopInset;
    }

    protected GuiButton getBackButton() {
        return _BackButton;
    }

    protected Resources getResources() {
        return _ResourceInstance;
    }
}
