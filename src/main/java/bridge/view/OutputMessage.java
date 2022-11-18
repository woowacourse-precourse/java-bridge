package bridge.view;

public enum OutputMessage {
    BRIDGE_IS_NUMBER("다리 길이는 숫자여야 합니다."),
    BRIDGE_HAS_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private static final String errorMessagePrefix = "[ERROR] ";
    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getErrorMessage() {
        return errorMessagePrefix + outputMessage;
    }
}
