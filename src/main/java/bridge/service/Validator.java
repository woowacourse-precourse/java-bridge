package bridge.service;

public class Validator {

    public void validateBridgeLength(String bridgeLength) {

    }

    private void validatePositiveNumber(String bridgeLength) {
        if (!bridgeLength.matches("[1-9][0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력값이 양의 정수가 아닙니다.");
        }
    }

    public void validateMovement(String movement) {

    }

    public void validateRetryStatus(String retryStatus) {

    }
}
