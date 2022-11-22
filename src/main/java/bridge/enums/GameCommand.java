package bridge.enums;

import java.util.Arrays;

public enum GameCommand {

    GAME_RESTART("R"),
    GAME_QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand getEnum(String inputCommand) {
        return Arrays.stream(values())
                .filter(gameCommand -> isCommandEqual(gameCommand, inputCommand))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("[ERROR] 게임 재시도 여부는 R이나 Q만 입력가능합니다."));
    }

    private static boolean isCommandEqual(GameCommand gameCommand, String inputCommand) {
        return gameCommand.command.equals(inputCommand);
    }

    public boolean isGameRestart() {
        return this == GAME_RESTART;
    }
}
