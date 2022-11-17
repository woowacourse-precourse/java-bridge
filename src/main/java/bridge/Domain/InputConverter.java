package bridge.Domain;

public class InputConverter {
    private static final String WRONG_INPUT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String EMPTY_INPUT = "[ERROR] 빈 문자입니다.";

    public static int convertToInt(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }

        try {
            return Integer.parseInt(input);
        } catch (Exception exception){
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }
}
