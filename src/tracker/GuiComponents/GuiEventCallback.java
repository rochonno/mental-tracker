package tracker.GuiComponents;

import com.codename1.io.Log;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GuiEventCallback implements ActionListener, DataChangedListener {

    private GuiComponent _Cmp;
    private Method _CallbackMethod;

    public GuiEventCallback (GuiComponent cmp, Method method)
    {
        _Cmp = cmp;
        _CallbackMethod = method;
    }

    /**
     * Invoked when an action occurred on a component
     *
     * @param evt event object describing the source of the action as well as
     *            its trigger
     */
    public void actionPerformed(ActionEvent evt) {
        try {
            _CallbackMethod.invoke(evt);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            Log.e(e.getCause());
        }
    }

    /**
     * Invoked when there was a change in the underlying model
     *
     * @param type  the type data change; REMOVED, ADDED or CHANGED
     * @param index item index in a list model
     */
    public void dataChanged(int type, int index) {

    }
}
