package string_calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("입력된 문자열이 null 또는 빈 문자열인 경우")
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

    @Test
    @DisplayName("구분자 없이 숫자만 입력된 경우")
    public void only_number() throws Exception {
        // given
        String onlyNumber = "3";

        // then
        assertEquals(3, stringCalculator.add(onlyNumber));

    }

    @Test
    @DisplayName("구분자 없이 숫자가 하나인데 음수인 경우")
    public void containNegativeNumber() throws Exception {
        // given
        String onlyNumber2 = "-1";

        // then
        assertThrowsExactly(RuntimeException.class, () -> stringCalculator.add(onlyNumber2));

    }

}