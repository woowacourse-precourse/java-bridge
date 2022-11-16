package bridge.output.message;

public enum Read {

    BRIDGE_SIZE("다리의 길이를 입력해주세요.");

    private final String message;

    Read(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
