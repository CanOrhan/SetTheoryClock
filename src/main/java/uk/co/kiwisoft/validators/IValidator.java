package uk.co.kiwisoft.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ToDo: Explain the purpose of the class
 */
public interface IValidator {
    String EXPRESSION = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]) and ([0-9]|0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]) second(s)?$";

    boolean validate(String input);
}
