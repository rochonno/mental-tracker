package tracker.Data.Storage;

import java.util.Calendar;
import java.util.Date;

public final  class FileNameGenerator {

    private FileNameGenerator() {
    }

    /** Name for the prompt result files. */
    private static final String PROMPT_RESULTS_ENDING = "_PromptResults";

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
