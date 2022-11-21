package bridge.util;

public enum CommandKeys {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q"),
    CORRECT("O"),
    WRONG("X");

    private final String letter;

    CommandKeys(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public static boolean isSame(CommandKeys commandKey, String input) {
        return commandKey.letter.equals(input);
    }
}
