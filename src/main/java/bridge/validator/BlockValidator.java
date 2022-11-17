package bridge.validator;

public class BlockValidator {
    private final static String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U와 D로만 입력할 수 있습니다.";

    public static void validateInvalidType(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }
}
