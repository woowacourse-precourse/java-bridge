package bridge;

public class BridgeLengthValidator {

    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static void validate(String input) {
        checkNumberFormat(input);
        checkNumberRange(input);
    }

    private static void checkNumberFormat(String input) {
        if(!input.matches(NUMBER_REGEX))
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    private static void checkNumberRange(String input) {
        try {
            int length = Integer.parseInt(input);
            if(length < 3 || length > 20) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

}
