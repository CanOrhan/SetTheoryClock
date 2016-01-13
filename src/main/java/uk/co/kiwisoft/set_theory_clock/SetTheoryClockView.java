package uk.co.kiwisoft.set_theory_clock;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SetTheoryClockView implements ISetTheoryClock{
    private final PrintStream outputStream;

    private String secondBlinker = ".";
    private String fiveHourSet = "....";
    private String hourlySet = "....";
    private String fiveFifteenMinuteSet = "..........";
    private String minuteSet = "....";
    private Date time = new Date();


    public SetTheoryClockView(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public void drawClock() {
        updateTimes();

        printClock(outputStream);
    }

    private void printClock(PrintStream outputStream) {
        outputStream.println(secondBlinker);
        outputStream.println(fiveHourSet);
        outputStream.println(hourlySet);
        outputStream.println("----");
        outputStream.println(fiveFifteenMinuteSet);
        outputStream.println(minuteSet);
    }

    private void updateTimes() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        secondBlinker = ".";
        if(calendar.get(Calendar.SECOND) % 2 == 0) {
            secondBlinker = "Y";
        }

        fiveHourSet = "....";
        double lightsLit = Math.floor(calendar.get(Calendar.HOUR_OF_DAY) / 5);
        for(int i = 0; i <  lightsLit; i++) {
            fiveHourSet = ("R" + fiveHourSet).substring(0, 4);
        }

        hourlySet = "....";
        for(int i = 0; i < calendar.get(Calendar.HOUR_OF_DAY) % 5; i++) {
            hourlySet = ("R" + hourlySet).substring(0, 4);
        }

        fiveFifteenMinuteSet = "";
        lightsLit = Math.floor(calendar.get(Calendar.MINUTE) / 5);
        for(int i = 0; i < lightsLit; i++) {
            String lightColor;
            switch(i){
                case 2:
                case 5:
                case 8:
                    lightColor = "R";
                    break;
                default:
                    lightColor = "Y";
            }
            fiveFifteenMinuteSet += lightColor;
        }
        fiveFifteenMinuteSet += "..........".substring(0, 10 - fiveFifteenMinuteSet.length());

        minuteSet = "....";
        for(int i = 0; i < calendar.get(Calendar.MINUTE) % 5; i++) {
            minuteSet = ("Y" + minuteSet).substring(0,4);
        }
    }

    public void setTime(Date time) {
        this.time = time;
        updateTimes();
    }

    public String getSecondBlinker() {
        return secondBlinker;
    }

    public String getFiveHourSet() {
        return fiveHourSet;
    }

    public String getHourlySet() {
        return hourlySet;
    }

    public String getFiveFifteenMinuteSet() {
        return fiveFifteenMinuteSet;
    }

    public String getMinuteSet() {
        return minuteSet;
    }
}
