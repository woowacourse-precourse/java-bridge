package bridge;

public class InputValidator {
    private static final String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";

    public static void inputBridgeSizeValidate(String bridgeSize) {
        checkNumber(bridgeSize);
    }

    public static void checkNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
