package bridge.constant;

import java.util.Arrays;

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

    public static Command searchCommand(String input) {
        return Arrays.stream(Command.values())
                .filter(command -> input.equals(command.command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("허용되지 않는 값! R(재시작) Q(종료) 중 하나를 입력하셔야 합니다!"));
    }
}
