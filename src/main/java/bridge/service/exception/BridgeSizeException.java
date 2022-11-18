package bridge.service.exception;

public class BridgeSizeException {

    private static final String START_ERROR_MESSAGE = "[ERROR] ";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    public static void checkConvertToNumber(String size) {
        try {
            Integer.parseInt(size);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(START_ERROR_MESSAGE + NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
