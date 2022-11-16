package bridge.output.message;

public enum Read {

    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D");

    private final String message;

    Read(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
