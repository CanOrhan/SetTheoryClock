package uk.co.kiwisoft;

import uk.co.kiwisoft.set_theory_clock.ISetTheoryClock;
import uk.co.kiwisoft.set_theory_clock.SetTheoryClockView;
import uk.co.kiwisoft.util.StringJoiner;
import uk.co.kiwisoft.validators.DateInputValidator;
import uk.co.kiwisoft.validators.IValidator;

public class Main {

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner();
        String input = joiner.join(args);

        IValidator dateInputValidator = new DateInputValidator();
        if(dateInputValidator.validate(input)) {
            showTime(input);
        } else {
            requestProperInput();
        }
    }

    private static void requestProperInput() {
        System.out.println("Please use the following format");
        System.out.println("HH:MM and ss seconds");
    }

    private static void showTime(String input) {
        InputDateAdapter adapter = new InputDateAdapter();
        ISetTheoryClock clockView = new SetTheoryClockView(System.out);

        clockView.setTime(adapter.convert(input));
        clockView.drawClock();
    }
}
