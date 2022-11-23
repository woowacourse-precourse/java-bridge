package bridge.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static boolean doRetry(String command) {
        if (!Arrays.stream(GameCommand.values())
                .map(GameCommand::getCommand)
                .collect(Collectors.toSet()).contains(command)) {
            throw new IllegalArgumentException("R 또는 Q를 입력해주세요.");
        }
        return command.equals(RETRY.getCommand());
    }
}
