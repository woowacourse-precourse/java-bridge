package bridge.validator;

public class BridgeMakerValidator {

    private static final String INVALID_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public void validateNumber(String inputNumber) {
        int bridgeSize = Integer.parseInt(inputNumber);

        if (!isNumeric(inputNumber)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
        }
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
        }
    }

    public boolean isNumeric(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}