package bridge.exception;

public class UserInputException {

    private static final String ERROR_IS_NOT_NUMBER = "숫자를 입력해 주세요.";
    private static final String ERROR_SIZE_ZERO = "적어도 한 글자 이상 입력 해야 합니다.(공백은 무시)";
    private static final String ERROR_INVALID_COMMAND_SIZE = "한 글자만 입력해 주세요.";
    private static final String ERROR_IS_NOT_UPPERCASE_CHARACTER = "대문자 알파벳을 입력해 주세요.";


    public static void isNotNumber() {
        throw new NumberFormatException(ERROR_IS_NOT_NUMBER);
    }

    public static void sizeZero() {
        throw new IllegalArgumentException(ERROR_SIZE_ZERO);
    }

    public static void invalidCommandSize() {
        throw new IllegalArgumentException(ERROR_INVALID_COMMAND_SIZE);
    }

    public static void isNotUpperCaseCharacter() {
        throw new IllegalArgumentException(ERROR_IS_NOT_UPPERCASE_CHARACTER);
    }


}
