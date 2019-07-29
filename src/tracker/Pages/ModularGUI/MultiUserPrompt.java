package tracker.Pages.ModularGUI;

import com.codename1.io.Log;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.PromptResult;
import tracker.GuiComponents.Containers.SinglePromptDisplay;
import tracker.GuiComponents.Individual.GuiButton;
import tracker.GuiComponents.Individual.GuiLabel;
import tracker.GuiComponents.ImageNames;
import tracker.MentalExceptions.EmptyStringException;

import java.util.List;
import java.util.Vector;

import static com.codename1.ui.util.Resources.getGlobalResources;

/**
 * @author Nolan Rochon
 *
 * Parent page for the prompts.
 * This genereates each prompt and collects the input from the user.
 */
public class MultiUserPrompt extends Form {

    private Form _NextForm;
    private Form _PrevForm;

    private InstanceData _Data;

    private Resources _ResourceInstance;

    private GuiButton _BackButton;
    private GuiLabel _TopInset;
    private GuiButton _NextButton;

    private List<SinglePromptDisplay> _GuiPrompts = new Vector<>();

    public MultiUserPrompt(InstanceData data, Form previous) {
        _Data = data;
        _PrevForm = previous;
        _ResourceInstance = getGlobalResources();

        initilizeLayout();
        if (_Data.getInstancePrompts().getPromptCount() >= 4) {
            createFourPrompts();
        } else if (_Data.getInstancePrompts().getPromptCount() == 3) {
            createThreePrompts();
        } else if (_Data.getInstancePrompts().getPromptCount() == 2) {
            createTwoPrompts();
        } else if (_Data.getInstancePrompts().getPromptCount() == 1) {
            createSinglePrompt();
        } else {
            promptsComplete();
        }
    }

    private void initilizeLayout() {
        setLayout(new LayeredLayout());
        setInlineStylesTheme(_ResourceInstance);
        setScrollableY(false);
        setInlineStylesTheme(_ResourceInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Mental Tracker");
        setName("Questionnaire");

        createDefaultComponents();
    }

    private void createDefaultComponents() {
        PageCallbackClass callback = new PageCallbackClass();

        _TopInset = new GuiLabel("TopInset", _ResourceInstance);
        _BackButton = new GuiButton(
                ImageNames.BACK_UNSELECT,
                _ResourceInstance,
                ImageNames.BACK_UNSELECT,
                ImageNames.BACK_SELECT
        );
        _NextButton = new GuiButton(
                ImageNames.CONTINUE_UNSELECT,
                _ResourceInstance,
                ImageNames.CONTINUE_UNSELECT,
                ImageNames.CONTINUE_SELECT

        );

        _BackButton.setActionListener(callback);
        _NextButton.setActionListener(callback);

        initTopInset();
        initBackButton();
        initNextButton();
    }

    private void initTopInset() {
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

    private void initBackButton() {
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

    private void initNextButton() {
        _NextButton.setSizeStr( "116.93122mm 23.544973mm");
        addComponent(_NextButton.getButton());

        ((LayeredLayout) _NextButton.getButton().
                getParent().getLayout()).setInsets(
                _NextButton.getButton(),
                "auto -125% 0 auto");
    }

    private void createFourPrompts() {
        createThreePrompts();
        _GuiPrompts.add(createPrompt(4));
    }

    private void createThreePrompts() {
        createTwoPrompts();
        _GuiPrompts.add(createPrompt(3));
    }

    private void createTwoPrompts() {
        createSinglePrompt();
        _GuiPrompts.add(createPrompt(2));
    }

    private void createSinglePrompt() {
        _GuiPrompts.add(createPrompt(1));
    }

    private void promptsComplete() {

    }

    private SinglePromptDisplay createPrompt(final int location) {
        MentalPrompt prompt = _Data.getInstancePrompts().remove(0);
        SinglePromptDisplay newPrompt = new SinglePromptDisplay(this, prompt, _ResourceInstance);
        newPrompt.initialize(location, _BackButton.getButton());
        return newPrompt;
    }

    private void onBackButtonEvent(final ActionEvent ev) {
        _PrevForm.showBack();
    }

    private void onNextButtonEvent(final ActionEvent ev) {

        if (!checkForAnswers()) {
            // TODO: remind the user to answer all the prompts
            return;
        }
        convertAnswers();
        MultiUserPrompt nextPrompts =
                new MultiUserPrompt(_Data, this);
        nextPrompts.show();

    }

    private boolean checkForAnswers()
    {
        boolean answered = true;

        for (SinglePromptDisplay guiPrompt : _GuiPrompts) {
            if (guiPrompt.getResult() == null) {
                answered = false;
            } else if (guiPrompt.getResult().length() == 0) {
                answered = false;
            }
        }

        return answered;
    }

    private void convertAnswers() {
        for (SinglePromptDisplay guiPrompt : _GuiPrompts) {
            MentalPrompt prompt = guiPrompt.getPrompt();
            PromptResult result = null;
            try {
                result = new PromptResult(
                        prompt.getName(),
                        prompt.getDataType(),
                        guiPrompt.getResult()
                );
            } catch (EmptyStringException ex) {
                Log.e(ex.getCause());
            }

            if (result != null) {
                _Data.getInstanceResults().addResult(result);
            }
        }
    }


    class PageCallbackClass implements ActionListener, DataChangedListener {

        PageCallbackClass() {
        }
        /**
         * Invoked when there was a change in the underlying model.
         *
         * @param type  the type data change; REMOVED, ADDED or CHANGED
         * @param index item index in a list model
         */
        public void dataChanged(final int type, final int index) {
        }

        /**
         * Invoked when an action occurs.
         *
         * @param ev the event to be processed
         */
        public void actionPerformed(final ActionEvent ev) {
            String sourceName = ev.getComponent().getName();

            if (sourceName == _BackButton.getName()) {
                onBackButtonEvent(ev);
            } else if (sourceName == _NextButton.getName()) {
                onNextButtonEvent(ev);
            }
        }
    }
}
