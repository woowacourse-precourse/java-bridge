package bridge;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static GameCommand getGameCommand(String command) {
        return Arrays.stream(values())
                .filter(gameCommand -> command.equals(gameCommand.command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 게임의 재시작 여부는 R(Restart), Q(Quit) 둘 중의 하나의 값이여야 합니다."));
    }
}
