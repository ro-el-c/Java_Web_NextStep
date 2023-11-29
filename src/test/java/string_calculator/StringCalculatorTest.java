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
    
    @Test
    @DisplayName("쉼표 또는 세미콜론을 구분자로 2개 이상의 숫자를 입력한 경우")
    public void numbers_with_comma() throws Exception {
        // given
        String text = "1,2";
        String text2 = "1,2:3";
                
        // when
        int result = stringCalculator.add(text);
        int result2 = stringCalculator.add(text2);

        // then
        assertEquals(3, result);
        assertEquals(6, result2);

    }

    @Test
    @DisplayName("커스텀 구분자를 사용하는 경우")
    public void custom_delimiter() throws Exception {
        // given
        String textWithDelimiter = "//@\n6@7@1@2";

        // when
        int answer = 16;
        int result = stringCalculator.add(textWithDelimiter);

        // then
        assertEquals(answer, result);

    }

    @Test
    @DisplayName("음수를 전달하는 경우")
    public void negative_number() throws Exception {
        // given
        String withNegativeNumber = "-1,3:5";

        // then
        assertThrowsExactly(RuntimeException.class, () -> stringCalculator.add(withNegativeNumber));

    }
}