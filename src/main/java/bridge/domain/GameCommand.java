package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand findByCommand(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> command.equals(gameCommand.getCommand()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 GameCommand를 찾을 수 없습니다."));
    }

    public String getCommand() {
        return this.command;
    }

}
