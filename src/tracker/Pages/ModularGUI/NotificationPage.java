package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import tracker.Data.InstanceData;
import tracker.Data.Reminders.MedReminder;
import tracker.Data.Reminders.PromptsReminder;
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
    public NotificationPage(InstanceData data, Form previous) {
        super(data, previous, "NotificationPage");

        createAllComponents();
    }

    private PromptsReminder _PromptsReminder;
    private MedReminder _MedReminder;

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

        _PromptTime = new GuiTimePicker("PromptTime", getResources());
        _MedTime = new GuiTimePicker("MedTime", getResources());
        _PromptTime.setActionListener(callback);
        _MedTime.setActionListener(callback);
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
        if (_PromptsReminder == null) {
            _PromptsReminder = new PromptsReminder();
        }

        if (_PromptRemindSwitch.getValue()) {
            _PromptsReminder.createNotification();
        } else {
            _PromptsReminder.deactivate();
        }
    }

    private void onMedRemindSwitch() {
        if (_MedReminder == null) {
            _MedReminder = new MedReminder();
        }

        if (_MedRemindSwitch.getValue()) {
            _MedReminder.createNotification();
        } else {
            _MedReminder.deactivate();
        }
    }

    private void onPromptTime() {
        if (_PromptsReminder == null) {
            _PromptsReminder = new PromptsReminder();
        }
        int minutes = _PromptTime.getTotalMins();
        int hour = minutes / 60;
        int min = minutes % 60;

        _PromptsReminder.setHour(hour);
        _PromptsReminder.setMinute(min);

        if (_PromptRemindSwitch.getValue()) {
            _PromptsReminder.createNotification();
        }
    }

    private void onMedTime() {
        if (_MedReminder == null) {
            _MedReminder = new MedReminder();
        }
        int minutes = _MedTime.getTotalMins();
        int hour = minutes / 60;
        int min = minutes % 60;

        _MedReminder.setHour(hour);
        _MedReminder.setMin(min);

        if (_MedRemindSwitch.getValue()) {
            _MedReminder.createNotification();
        }
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
        addComponent(_MedLabel.getLabel());

        ((LayeredLayout) _MedLabel.getLabel().getParent().getLayout()).
                setInsets(_MedLabel.getLabel(), "0 auto auto 2mm").
                setReferenceComponentTop(_MedLabel.getLabel(),
                        getBackButton().getButton(), location);
    }

    private void createPromptRemindSwitch() {
        addComponent(_PromptRemindSwitch.getSwitch());

        ((LayeredLayout) _PromptRemindSwitch.getSwitch().getParent().getLayout()).
                setInsets(_PromptRemindSwitch.getSwitch(), "0 auto auto 0").
                setReferenceComponentTop(_PromptRemindSwitch.getSwitch(),
                        _PromptLabel.getLabel(), 0).
                setReferenceComponentLeft(_PromptRemindSwitch.getSwitch(),
                        _PromptLabel.getLabel(), 1.1f);
    }

    private void createMedRemindSwitch() {
        addComponent(_MedRemindSwitch.getSwitch());

        ((LayeredLayout) _MedRemindSwitch.getSwitch().getParent().getLayout()).
                setInsets(_MedRemindSwitch.getSwitch(), "0 auto auto 0").
                setReferenceComponentTop(_MedRemindSwitch.getSwitch(),
                        _MedLabel.getLabel(), 0).
                setReferenceComponentLeft(_MedRemindSwitch.getSwitch(),
                        _PromptRemindSwitch.getSwitch(), 0);
    }

    private void createPromptTimePicker() {
        addComponent(_PromptTime.getPicker());

        ((LayeredLayout) _PromptTime.getPicker().getParent().getLayout()).
                setInsets(_PromptTime.getPicker(), "0 auto auto 0").
                setReferenceComponentTop(_PromptTime.getPicker(),
                        _PromptLabel.getLabel(), 1f).
                setReferenceComponentLeft(_PromptTime.getPicker(),
                        _PromptLabel.getLabel(), 0);
    }

    private void createMedTimePicker() {
        addComponent(_MedTime.getPicker());

        ((LayeredLayout) _MedTime.getPicker().getParent().getLayout()).
                setInsets(_MedTime.getPicker(), "0 auto auto 0").
                setReferenceComponentTop(_MedTime.getPicker(),
                        _MedLabel.getLabel(), 1f).
                setReferenceComponentLeft(_MedTime.getPicker(),
                        _MedLabel.getLabel(), 0);
    }
}
