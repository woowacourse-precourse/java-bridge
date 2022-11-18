package bridge.view;

public enum Messages {
    ERROR_INPUT_NUMBER("입력은 숫자만 가능합니다."),
    ERROR_BRIDGE_SIZE("다리의 길이는 3 ~ 20까지만 입력 가능합니다.");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
