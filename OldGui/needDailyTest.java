package tracker.Pages;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class needDailyTest extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("NeedDailyGUI");
        assertLabel("Label", "You still need to take today's survey!");
        assertLabel("TopInset", "");
        assertLabel("TakeSurvey", "Take Today's Survey!");
        assertTitle("NeedDailyGUI");
        clickButtonByName("TakeSurvey");
        waitForFormName("DailySurveyPgOneGUI");
        assertTitle("DailySurveyPgOneGUI");
        return true;
    }
}
