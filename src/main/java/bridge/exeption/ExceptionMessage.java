package bridge.exeption;

public enum ExceptionMessage {
    incorrectSize("[ERROR] 숫자를 입력해주세요."),
    sizeOverScope("[ERROR] 3 ~ 20 사이의 수를 입력해주세요."),
    bridgeNotEqualsSize("[ERROR] 다리의 길이가 입력값과 다릅니다."),
    createBridgeWordNotUD("[ERROR] 다리가 잘못 생성되었습니다."),
    moveByNotUD("[ERROR] U 또는 D을 입력해주세요."),
    commandByNotRQ("[ERROR] R 또는 Q을 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
