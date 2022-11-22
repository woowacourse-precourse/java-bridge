package bridge.enums;

/**
 * 사용자의 재시작 여부를 나타내는 커맨드이다.
 */
public enum Command {
    RESTART_COMMAND("R"),
    QUIT_COMMAND("Q"),
    ;
    private final String command;

    Command(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
