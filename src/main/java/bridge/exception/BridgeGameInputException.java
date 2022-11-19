package bridge.exception;

public class BridgeGameInputException {

    public void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3에서 20사이입니다.");
        }
    }
}

