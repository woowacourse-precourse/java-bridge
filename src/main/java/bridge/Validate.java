package bridge;

import java.util.regex.Pattern;

public class Validate {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+[0-9]*$");

    public static void validateInputNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
    public static void validateInputMove(String userInput) {
        if (!(userInput.equals("U") || userInput.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 만 입력 가능합니다.");
        }
    }
    public static void validateInputRetry(String userInput) {
        if (!(userInput.equals("Q") || userInput.equals("R"))) {
            throw new IllegalArgumentException("[ERROR] Q 또는 R 만 입력 가능합니다.");
        }
    }
}
