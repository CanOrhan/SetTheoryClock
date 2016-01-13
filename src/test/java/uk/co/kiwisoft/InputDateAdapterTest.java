package uk.co.kiwisoft;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class InputDateAdapterTest {
    InputDateAdapter adapter;

    @Before
    public void setUp() throws Exception {
        adapter = new InputDateAdapter();
    }

    @Test
    public void testValidInput() throws Exception {
        Date date = adapter.convert("01:02 and 03 seconds");
        assertEquals(3723000l, date.getTime());
    }

    @After
    public void tearDown() throws Exception {
        adapter = null;
    }
}