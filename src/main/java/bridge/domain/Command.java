package bridge.domain;

import java.util.Arrays;

public enum Command {

    RETRY("R"),
    QUIT("Q"),
    ;

    public final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command getCommand(String command) {
        return Arrays.stream(Command.values())
                .filter(c -> c.command.equals(command))
                .findAny()
                .orElseThrow(() -> Config.EXCEPTION);
    }

    static class Config {
        private static final IllegalArgumentException EXCEPTION = new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다.");
    }
}
