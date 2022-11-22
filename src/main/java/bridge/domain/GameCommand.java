package bridge.domain;

import bridge.constant.ErrorMessage;

public class GameCommand {
    private static final String RESTART_CHARACTER = "R";
    private static final String QUIT_CHARACTER = "Q";

    private final String value;

    public GameCommand(String gameCommandValue){
        validateGameCommandValue(gameCommandValue);
        this.value = gameCommandValue;
    }

    private void validateGameCommandValue(String gameCommandValue){
        if (!gameCommandValue.equals(RESTART_CHARACTER) && !gameCommandValue.equals(QUIT_CHARACTER)){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_GAME_COMMAND_CHARACTER.getMessage());
        }
    }

    public static String getRestartCharacter() {
        return RESTART_CHARACTER;
    }

    public static String getQuitCharacter() {
        return QUIT_CHARACTER;
    }

    public String getValue() {
        return value;
    }
}
