package bridge.value;

import static bridge.validate.GameValidation.validateGameCommand;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private final String character;

    public static GameCommand makeGameCommand(String command) {
        validateGameCommand(command);
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.character.equals(command))
                .findAny().get();
    }

    GameCommand(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
