package string_calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String inputText) {
        List<Integer> numbers;

        if (inputText == null || inputText.isBlank()) {
            return 0;
        }

        try {
            int number = Integer.parseInt(inputText);
            if (number < 0) {
                throw new RuntimeException("음수가 존재합니다.");
            }
            return number;
        } catch (Exception e) {
            String[] numberStrings;

            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputText);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                numberStrings = matcher.group(2).split(customDelimiter);
            } else {
                numberStrings = inputText.split(", | :");
            }

            numbers = Arrays.stream(numberStrings).map(Integer::parseInt).toList();
            if (numbers.stream().anyMatch(number -> number < 0)) {
                throw new RuntimeException("음수가 존재합니다.");
            }

        }

        int result = 0;
        for (Integer num : numbers) {
            result += num;
        }

        return result;
    }
}
