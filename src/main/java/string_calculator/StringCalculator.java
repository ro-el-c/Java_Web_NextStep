package string_calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final int MIN_NUM_OF_DIGIT = 1;

    public int add(String inputText) {
        List<Integer> numbers;

        if (inputText == null || inputText.isBlank()) {
            return 0;
        }

        String[] numberStrings;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            numberStrings = matcher.group(2).split(customDelimiter);
        } else { //TODO: else 제거
            numberStrings = inputText.split(",|;");
        }

        numbers = toIntegerList(numberStrings);
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new RuntimeException("음수가 존재합니다.");
        }

        if (numbers.size() == MIN_NUM_OF_DIGIT) {
            return Integer.parseInt(inputText);
        }

        int result = sum(numbers);

        return result;
    }

    private static List<Integer> toIntegerList(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .toList();
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer num : numbers) {
            result += num;
        }
        return result;
    }
}
