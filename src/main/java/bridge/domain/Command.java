package bridge.domain;

public enum Command {
    RETRY("R"),
    END("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command get(String input) {
        if (input.equals("R")) {
            return RETRY;
        }
        if (input.equals("Q")) {
            return END;
        }
        throw new IllegalArgumentException("[ERROR] 재시작 여부 명령은 R또는 Q만 입력할 수 있습니다.");
    }
}
