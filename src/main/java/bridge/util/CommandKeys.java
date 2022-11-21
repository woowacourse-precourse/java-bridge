package bridge.util;

public enum CommandKeys {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String letter;

    CommandKeys(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public static boolean isUp(String input) {
        return CommandKeys.UP.letter.equals(input);
    }

    public static boolean isDown(String input) {
        return CommandKeys.DOWN.letter.equals(input);
    }

    public static boolean isRetry(String input) {
        return CommandKeys.RETRY.letter.equals(input);
    }

    public static boolean isQuit(String input) {
        return CommandKeys.QUIT.letter.equals(input);
    }
}
