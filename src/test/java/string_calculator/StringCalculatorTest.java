package string_calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void null_or_blank() throws Exception {
        // given
        String nullText = null;
        String none = "";
        String withBlank = " ";
        
        // then
        assertEquals(0, stringCalculator.add(nullText));
        assertEquals(0, stringCalculator.add(none));
        assertEquals(0, stringCalculator.add(withBlank));
    }

}