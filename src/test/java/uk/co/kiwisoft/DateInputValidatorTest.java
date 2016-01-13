package uk.co.kiwisoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.co.kiwisoft.validators.DateInputValidator;

import static org.junit.Assert.*;

public class DateInputValidatorTest {

    DateInputValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new DateInputValidator();
    }

    @Test
    public void testInvalidInputs() throws Exception {
        assertNotNull(validator);
        assertFalse(validator.validate(null));
        assertFalse(validator.validate("Invalid Input"));
        assertFalse(validator.validate("9:45"));
        assertFalse(validator.validate("25:45 and 02 seconds"));
    }

    @Test
    public void testValidInputs() throws Exception {
        assertTrue(validator.validate("9:45 and 01 second"));
        assertTrue(validator.validate("9:45 and 02 seconds"));
    }

    @After
    public void tearDown() throws Exception {
        validator = null;
    }
}