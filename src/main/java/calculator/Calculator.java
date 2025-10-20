package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {



    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }


        input = input.replace("\\n", "\n");

        String delimiter = "[,:]";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.matches()) {
            delimiter = "[,:" + Pattern.quote(matcher.group(1)) + "]";
            input = matcher.group(2);
        }

        return sumNumbers(input, delimiter);
    }

    private int sumNumbers(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("잘못된 입력: " + number);
            }
            sum += Integer.parseInt(number);
        }
        return sum;
    }


}
