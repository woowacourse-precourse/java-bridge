package bridge.constant;

public enum Command {

    DO_RETRY("R", "재시도"),
    DO_QUIT("Q", "종료");

    private final String command;
    private final String detail;

    Command(String command, String detail) {
        this.command = command;
        this.detail = detail;
    }

    public String getCommand() {
        return command;
    }

    public String getDetail() {
        return detail;
    }
}
