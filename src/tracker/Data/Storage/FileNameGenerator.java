package tracker.Data.Storage;

import java.util.Calendar;
import java.util.Date;

public class FileNameGenerator {

    private FileNameGenerator() {
    }

    private static final String PROMPT_RESULTS_ENDING = "_PromptResults";
    private static final String PROMPT_LIST_ENDING = "_MentalPrompts";
    private static final String NOTIFICAITONS = "NotificationSettings";

    public static String getPromptResultsFilename(final Date date) {
        return getDateStr(date) + PROMPT_RESULTS_ENDING;
    }

    private static String getDateStr(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        return Integer.toString(month)
                + "_" + Integer.toString(day)
                + "_" + Integer.toString(year);
    }
}
