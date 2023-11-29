package string_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SplitTest {
    @Test
    @DisplayName("쉼표를 포함하지 않는 문자열을 쉼표로 split")
    public void split_text_without_comma() throws Exception {
        // given
        String withComma = "1,2";
        String withoutComma = "1";

        // when
        String[] splitWithComma = withComma.split(",");
        String[] splitWithoutComma = withoutComma.split(",");

        String[] answerSplitWithComma = new String[]{"1", "2"};
        String[] answerSplitWithoutcomma = new String[]{"1"};

        // then
        assertArrayEquals(answerSplitWithComma, splitWithComma);
        assertArrayEquals(answerSplitWithoutcomma, splitWithoutComma);

    }
}
