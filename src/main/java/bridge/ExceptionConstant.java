package bridge;

public enum ExceptionConstant {
    NOT_NATURAL_NUMBER("다리 길이는 자연수여야 합니다."),

    INCORRECT_LENGTH(String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                          BridgeConstant.MIN_LENGTH, BridgeConstant.MAX_LENGTH));

    private final String message;

    ExceptionConstant(String message) {
        this.message = String.format("[ERROR] %s", message);
    }

    public String getMessage() {
        return message;
    }
}
