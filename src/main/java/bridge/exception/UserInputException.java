package bridge.exception;

public class UserInputException {

    private static final String ERROR_IS_NOT_NUMBER = "숫자를 입력해 주세요.";

    public static void isNotNumber() {
        throw new IllegalArgumentException(ERROR_IS_NOT_NUMBER);
    }


}
