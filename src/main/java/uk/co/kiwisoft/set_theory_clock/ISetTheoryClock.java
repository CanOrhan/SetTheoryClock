package uk.co.kiwisoft.set_theory_clock;

import java.util.Date;

/**
 * ToDo: Explain the purpose of the class
 */
public interface ISetTheoryClock {
    void drawClock();

    void setTime(Date time);

    String getSecondBlinker();

    String getFiveHourSet();

    String getHourlySet();

    String getFiveFifteenMinuteSet();

    String getMinuteSet();
}
