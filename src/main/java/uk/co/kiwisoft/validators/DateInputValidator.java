package uk.co.kiwisoft.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Takes date input and validates it
 */
public class DateInputValidator implements IValidator{

    public final static String EXPRESSION = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]) and ([0-9]|0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]) second(s)?$";

    public boolean validate(String input) {
        boolean isValid = false;
        if(input != null) {
            Pattern pattern = Pattern.compile(EXPRESSION, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            isValid = matcher.matches();
        }
        return isValid;
    }
}
