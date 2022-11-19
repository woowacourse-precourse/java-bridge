package bridge.enums;

public enum InputMsg {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.");

    private final String message;

    InputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
