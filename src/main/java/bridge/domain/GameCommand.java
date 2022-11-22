package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

public enum GameCommand {
    RESTART("R", "재시도"),
    QUIT("Q", "종료");

    private final String command;
    private final String word;

    GameCommand(String command, String word) {
        this.command = command;
        this.word = word;
    }

    public String getCommand() {
        return command;
    }

    public String getWord() {
        return word;
    }

    public static GameCommand parseCommandToInstance(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(game -> Objects.equals(game.getCommand(), command))
                .findFirst()
                .orElseThrow();
    }
}
