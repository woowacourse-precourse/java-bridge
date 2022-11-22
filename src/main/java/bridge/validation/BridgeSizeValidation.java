package bridge.validation;

public class BridgeSizeValidation {
    private final String ERROR_MESSAGE = "[ERROR] ";
    private final String NOT_NUMBER_ERROR_MSG = "숫자를 입력해주세요!";
    private final String RANGE_ERROR_MSG = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public void validate(String bridgeSize) {
        validateNumber(bridgeSize);
        int convertBridgeSize = Integer.parseInt(bridgeSize);
        validateRange(convertBridgeSize);
    }

    public void validateNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER_ERROR_MSG);
        }
    }

    private void validateRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + RANGE_ERROR_MSG);
        }
    }
}
