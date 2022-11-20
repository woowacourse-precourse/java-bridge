package bridge.value;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private final String character;

    public static GameCommand makeGameCommand(String character) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.character.equals(character))
                .findAny().orElseThrow(() -> new IllegalArgumentException("입력한 게임 제어 문자가 존재하지 않습니다."));
    }

    GameCommand(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
