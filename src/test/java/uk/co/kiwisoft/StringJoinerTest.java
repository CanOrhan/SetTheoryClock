package uk.co.kiwisoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.co.kiwisoft.util.StringJoiner;

import static org.junit.Assert.*;

public class StringJoinerTest {

    StringJoiner stringJoiner;

    @Before
    public void setUp() throws Exception {
        stringJoiner = new StringJoiner();
    }

    @Test
    public void testNullAndEmptyInput() throws Exception {
        assertEquals("", stringJoiner.join(null));
        assertEquals("", stringJoiner.join(new String[]{}));
        assertEquals("", stringJoiner.join(new String[]{""}));
    }

    @Test
    public void testValidInput() throws Exception {
        assertEquals("My Days", stringJoiner.join(new String[]{"My", "Days"}));
        assertEquals("21:12 and 00 seconds", stringJoiner.join(new String[]{"21:12", "and", "00", "seconds"}));
    }

    @After
    public void tearDown() throws Exception {
        stringJoiner = null;
    }
}