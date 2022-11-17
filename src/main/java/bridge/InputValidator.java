package bridge;

public class InputValidator {

    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    public static final String IS_NUMBER = "[0-9]*";
    public static final String BRIDGE_SIZE_ERROR = "[ERROR] 4-20사이의 숫자가 아닙니다.";

    private InputValidator() {
    }
    public static boolean isValidSize(String inputSize) {
        if (inputSize == null || inputSize.isBlank()) {
            return false;
        }
        if (!inputSize.matches(IS_NUMBER)){
            return false;
        }
        int size = Integer.parseInt(inputSize);
        return size <= BRIDGE_MAX_SIZE && size >= BRIDGE_MIN_SIZE;
    }

    public static void throwError(String errorMessage) {
        try {
            throw new IllegalArgumentException(errorMessage);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
