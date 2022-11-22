package bridge.constant;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q"),
    MISS("M"),
    ;

    private final String firstLetter;

    GameCommand(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public static GameCommand findByString(String string) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.equalFirstLetterWithString(string))
                .findAny()
                .orElse(MISS);
    }

    public boolean equalFirstLetterWithString(String string) {
        return firstLetter.equals(string);
    }

    public boolean isMiss() {
        return this == MISS;
    }

    public boolean isRestart() {
        return this == RESTART;
    }

    public boolean isQuit() {
        return this == QUIT;
    }
}
