package string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String inputText) {
        List<Integer> numbers;

        if (isBlank(inputText)) {
            return 0;
        }

        String[] numberStrings = splitText(inputText);
        numbers = toIntegerList(numberStrings);
        int result = sum(numbers);

        return result;

        //축약: return sum(toIntegerList(splitText(inputText)));
    }

    private static boolean isBlank(String inputText) {
        return inputText == null || inputText.isBlank();
    }

    private static String[] splitText(String inputText) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return inputText.split(",|:");
    }

    private static List<Integer> toIntegerList(String[] numberStrings) {
        List<Integer> numbers = new ArrayList<>();


        for (String numberText : numberStrings) {
            int number = toInteger(numberText);
            validateNumber(number);
            numbers.add(number);
        }

        return numbers;
    }

    private static int toInteger(String numberText) {
        try {
            return Integer.parseInt(numberText);
        } catch (Exception e) {
            throw new RuntimeException("숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    private static void validateNumber(Integer number) {
        if (number < 0) {
            throw new RuntimeException("음수가 존재합니다.");
        }
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer num : numbers) {
            result += num;
        }
        return result;
    }
}
