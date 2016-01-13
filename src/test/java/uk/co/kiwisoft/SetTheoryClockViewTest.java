package uk.co.kiwisoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.co.kiwisoft.set_theory_clock.SetTheoryClockView;

import java.util.Date;

import static org.junit.Assert.*;

public class SetTheoryClockViewTest {
    SetTheoryClockView clockView;

    @Before
    public void setUp() throws Exception {
        clockView = new SetTheoryClockView(System.out);
    }

    @Test
    public void testSecondsBlinker() throws Exception {
        Date date = new Date();
        date.setTime(2112);
        clockView.setTime(date);
        assertEquals("Y", clockView.getSecondBlinker());

        date.setTime(1000);
        clockView.setTime(date);
        assertEquals(".", clockView.getSecondBlinker());

        date.setTime(3000);
        clockView.setTime(date);
        assertEquals(".", clockView.getSecondBlinker());
    }

    @Test
    public void testFiveHourSet() throws Exception {
        Date date = new Date();
        date.setTime(0);
        clockView.setTime(date);
        assertEquals("....", clockView.getFiveHourSet());

        int hour = 3600000;
        date.setTime(hour);
        clockView.setTime(date);
        assertEquals("....", clockView.getFiveHourSet());

        date.setTime(hour * 4);
        clockView.setTime(date);
        assertEquals("....", clockView.getFiveHourSet());

        date.setTime(hour * 5);
        clockView.setTime(date);
        assertEquals("R...", clockView.getFiveHourSet());

        date.setTime(hour * 6);
        clockView.setTime(date);
        assertEquals("R...", clockView.getFiveHourSet());

        date.setTime(hour * 9);
        clockView.setTime(date);
        assertEquals("R...", clockView.getFiveHourSet());

        date.setTime(hour * 10);
        clockView.setTime(date);
        assertEquals("RR..", clockView.getFiveHourSet());

        date.setTime(hour * 14);
        clockView.setTime(date);
        assertEquals("RR..", clockView.getFiveHourSet());

        date.setTime(hour * 15);
        clockView.setTime(date);
        assertEquals("RRR.", clockView.getFiveHourSet());

        date.setTime(hour * 20);
        clockView.setTime(date);
        assertEquals("RRRR", clockView.getFiveHourSet());
    }

    @Test
    public void testIndividualHours() throws Exception {
        Date date = new Date();

        int hour = 3600000;
        date.setTime(hour);
        clockView.setTime(date);
        assertEquals("R...", clockView.getHourlySet());

        date.setTime(hour * 2);
        clockView.setTime(date);
        assertEquals("RR..", clockView.getHourlySet());

        date.setTime(hour * 6);
        clockView.setTime(date);
        assertEquals("R...", clockView.getHourlySet());

        date.setTime(hour * 19);
        clockView.setTime(date);
        assertEquals("RRRR", clockView.getHourlySet());

        date.setTime(hour * 23);
        clockView.setTime(date);
        assertEquals("RRR.", clockView.getHourlySet());
    }

    @Test
    public void testFiveFifteenMinuteSet() throws Exception {
        Date date = new Date();

        int minute = 60000;
        date.setTime(0);
        clockView.setTime(date);
        assertEquals("..........", clockView.getFiveFifteenMinuteSet());

        date.setTime(minute);
        clockView.setTime(date);
        assertEquals("..........", clockView.getFiveFifteenMinuteSet());

        date.setTime(minute * 5);
        clockView.setTime(date);
        assertEquals("Y.........", clockView.getFiveFifteenMinuteSet());

        date.setTime(minute * 17);
        clockView.setTime(date);
        assertEquals("YYR.......", clockView.getFiveFifteenMinuteSet());

        date.setTime(minute * 32);
        clockView.setTime(date);
        assertEquals("YYRYYR....", clockView.getFiveFifteenMinuteSet());

        date.setTime(minute * 45);
        clockView.setTime(date);
        assertEquals("YYRYYRYYR.", clockView.getFiveFifteenMinuteSet());

        date.setTime(minute * 51);
        clockView.setTime(date);
        assertEquals("YYRYYRYYRY", clockView.getFiveFifteenMinuteSet());
    }

    @Test
    public void testMinuteSet() throws Exception {
        Date date = new Date();

        int minute = 60000;
        date.setTime(0);
        clockView.setTime(date);
        assertEquals("....", clockView.getMinuteSet());

        date.setTime(minute * 5);
        clockView.setTime(date);
        assertEquals("....", clockView.getMinuteSet());

        date.setTime(minute);
        clockView.setTime(date);
        assertEquals("Y...", clockView.getMinuteSet());

        date.setTime(minute * 3);
        clockView.setTime(date);
        assertEquals("YYY.", clockView.getMinuteSet());

        date.setTime(minute * 13);
        clockView.setTime(date);
        assertEquals("YYY.", clockView.getMinuteSet());

        date.setTime(minute * 27);
        clockView.setTime(date);
        assertEquals("YY..", clockView.getMinuteSet());

    }

    @After
    public void tearDown() throws Exception {
        clockView = null;
    }
}