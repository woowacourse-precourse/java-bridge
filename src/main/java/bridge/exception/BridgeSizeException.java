package bridge.exception;

public class BridgeSizeException {

    private static final String PERMIT_NUM = "[0-9]+";
    private static final Integer BRIDGE_SIZE_MIN = 3;
    private static final Integer BRIDGE_SIZE_MAX = 20;

    public boolean isBridgeSizeValid(String bridgeSize) {
        boolean isInputValid = true;
        try {
            isBridgeSizeConsistOfNumber(bridgeSize);
            isBridgeSizeInRange(Integer.valueOf(bridgeSize));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            isInputValid = false;
        } finally {
            return isInputValid;
        }
    }

    public void isBridgeSizeConsistOfNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isUserInputContainsOnlyNumber(input)) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자로 이루어져야 합니다");
            }
        }
    }

    public void isBridgeSizeInRange(Integer input) {
        if (input < BRIDGE_SIZE_MIN || input > BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private boolean isUserInputContainsOnlyNumber(String input) {
        if (input.matches(PERMIT_NUM)) {
            return true;
        }
        return false;
    }
}
