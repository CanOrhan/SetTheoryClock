package uk.co.kiwisoft;


import uk.co.kiwisoft.validators.DateInputValidator;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Converts a string input to a Date object.
 * Please use DateInputValidator to validate input.
 */
public class InputDateAdapter {
    private static final long SECOND_TO_MILI = 1000;
    private static final long MIN_TO_MILI = 60 * SECOND_TO_MILI;
    private static final long HOUR_TO_MILI = 60 * MIN_TO_MILI;

    public Date convert(String input) {
        Date date = new Date();
        Pattern pattern = Pattern.compile(DateInputValidator.EXPRESSION, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        matcher.matches();

        long secondsInMilis = (Long.valueOf(matcher.group(3)) * SECOND_TO_MILI);
        long minsInMilis = (Long.valueOf(matcher.group(2)) * MIN_TO_MILI);
        long hoursInMilis = (Long.valueOf(matcher.group(1)) * HOUR_TO_MILI);

        date.setTime(secondsInMilis + minsInMilis + hoursInMilis);

        return date;
    }
}
