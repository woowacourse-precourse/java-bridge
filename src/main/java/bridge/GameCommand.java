package bridge;

import static bridge.ErrorMessage.INVALID_GAME_COMMAND_ERROR;

import java.util.Arrays;

public enum GameCommand {

    RETRY("R"), QUIT("Q");

    private final String inputSymbol;

    GameCommand(String inputSymbol) {
        this.inputSymbol = inputSymbol;
    }

    public static GameCommand getEnum(String inputSymbol) {
        return Arrays.stream(values())
                .filter(symbol -> symbol.inputSymbol.equals(inputSymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR));
    }
}
