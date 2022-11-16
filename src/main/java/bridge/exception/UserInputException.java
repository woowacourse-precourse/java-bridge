package bridge.exception;

public class UserInputException {

    private static final String ERROR_IS_NOT_NUMBER = "양의 숫자를 입력해 주세요.";
    private static final String ERROR_SIZE_ZERO = "적어도 한 글자 이상 입력 해야 합니다.(공백은 무시)";

    public static void isNotPositiveNumber() {
        throw new IllegalArgumentException(ERROR_IS_NOT_NUMBER);
    }

    public static void sizeZero() {
        throw new IllegalArgumentException(ERROR_SIZE_ZERO);
    }
}
