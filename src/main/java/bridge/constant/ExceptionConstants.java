package bridge.constant;

public enum ExceptionConstants {
    NOT_NATURAL_NUMBER("다리 길이는 자연수여야 합니다."),
    INCORRECT_RANGE(String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
            BridgeConstants.MINIMUM_LENGTH, BridgeConstants.MAXIMUM_LENGTH));

    private final String message;

    ExceptionConstants(String message) {
        this.message = String.format("[ERROR] %s", message);
    }

    public String getMessage() {
        return message;
    }
}
