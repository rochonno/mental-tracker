package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import tracker.Data.InstanceData;
import tracker.GuiComponents.Individual.GuiButton;
import tracker.GuiComponents.Individual.GuiLabel;
import tracker.GuiComponents.Individual.GuiSwitch;
import tracker.GuiComponents.Individual.GuiTimePicker;

public class NotificationPage extends DefaultPageComponents {

    /**
     * Constructor for the DefaultComponents class.
     *
     * @param data     instance data
     * @param previous previous page
     */
    NotificationPage(InstanceData data, Form previous) {
        super(data, previous, "NotificationPage");

        createAllComponents();
    }

    /**
     * Initializes and creates all components for this page.
     */
    private void createAllComponents() {
        initDefault();
        createDefaults();

        initLabels();
        initSwitches();
        initTimePickers();

        createLabels();
        createSwitches();
        createTimePickers();
    }

    private GuiLabel _PromptLabel;
    private GuiLabel _MedLabel;

    private GuiSwitch _PromptRemindSwitch;
    private GuiSwitch _MedRemindSwitch;

    private GuiTimePicker _PromptTime;
    private GuiTimePicker _MedTime;

    private void initLabels() {
        _PromptLabel = new GuiLabel("PromptRemind", getResources());
        _PromptLabel.setText("Daily Survey Reminder");

        _MedLabel = new GuiLabel("MedRemind", getResources());
        _MedLabel.setText("Daily Meds Reminder");
    }

    private void initSwitches() {
        ReminderEventCallback callback = new ReminderEventCallback();

        _PromptRemindSwitch = new GuiSwitch("PromptSwitch", getResources());
        _PromptRemindSwitch.addActionListener(callback);
        _MedRemindSwitch = new GuiSwitch("MedSwitch", getResources());
        _MedRemindSwitch.addActionListener(callback);
    }

    private void initTimePickers() {
        ReminderEventCallback callback = new ReminderEventCallback();

        _PromptTime = new GuiTimePicker("PromptTime");
        _MedTime = new GuiTimePicker("MedTime");
    }


    class ReminderEventCallback implements ActionListener {

        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            String sourceName = evt.getComponent().getName();

            if (sourceName.equals(_PromptRemindSwitch.getName())) {
                onPromptRemindSwitch();
            } else if (sourceName.equals(_MedRemindSwitch.getName())) {
                onMedRemindSwitch();
            } else if (sourceName.equals(_PromptTime.getName())) {
                onPromptTime();
            } else if (sourceName.equals(_MedTime.getName())) {
                onMedTime();
            }
        }
    }

    private void onPromptRemindSwitch() {

    }

    private void onMedRemindSwitch() {

    }

    private void onPromptTime() {

    }

    private void onMedTime() {

    }


    private void createLabels() {
        float location = 3f;
        createPromptLabel(location);
        location += 2f;
        createMedLabel(location);
    }

    private void createSwitches() {
        createPromptRemindSwitch();
        createMedRemindSwitch();
    }

    private void createTimePickers() {
        createPromptTimePicker();
        createMedTimePicker();
    }

    private void createPromptLabel(final float location) {
        addComponent(_PromptLabel.getLabel());

        ((LayeredLayout) _PromptLabel.getLabel().getParent().getLayout()).
                setInsets(_PromptLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_PromptLabel.getLabel(),
                        getBackButton().getButton(), location);
    }

    private void createMedLabel(final float location) {
        addComponent(_PromptLabel.getLabel());

        ((LayeredLayout) _PromptLabel.getLabel().getParent().getLayout()).
                setInsets(_PromptLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_PromptLabel.getLabel(),
                        getBackButton().getButton(), location);
    }

    private void createPromptRemindSwitch() {
        addComponent(_PromptRemindSwitch.getSwitch());

        ((LayeredLayout) _PromptRemindSwitch.getSwitch().getParent().getLayout()).
                setInsets(_PromptRemindSwitch.getSwitch(), "0 auto auto 0").
                setReferenceComponentTop(_PromptRemindSwitch.getSwitch(),
                        _PromptLabel.getLabel(), 0).
                setReferenceComponentLeft(_PromptRemindSwitch.getSwitch(),
                        _PromptLabel.getLabel(), .2f);
    }

    private void createMedRemindSwitch() {
        addComponent(_MedRemindSwitch.getSwitch());

        ((LayeredLayout) _MedRemindSwitch.getSwitch().getParent().getLayout()).
                setInsets(_MedRemindSwitch.getSwitch(), "0 auto auto 0").
                setReferenceComponentTop(_MedRemindSwitch.getSwitch(),
                        _MedLabel.getLabel(), .5f).
                setReferenceComponentLeft(_MedRemindSwitch.getSwitch(),
                        _MedLabel.getLabel(), .2f);
    }

    private void createPromptTimePicker() {
        addComponent(_PromptTime.getPicker());

        ((LayeredLayout) _PromptTime.getPicker().getParent().getLayout()).
                setInsets(_PromptTime.getPicker(), "0 auto auto 0").
                setReferenceComponentBottom(_PromptTime.getPicker(),
                        _PromptLabel.getLabel(), 0);
    }

    private void createMedTimePicker() {
        addComponent(_MedTime.getPicker());

        ((LayeredLayout) _MedTime.getPicker().getParent().getLayout()).
                setInsets(_MedTime.getPicker(), "0 auto auto 0").
                setReferenceComponentBottom(_MedTime.getPicker(),
                        _MedLabel.getLabel(), 0);
    }
}
