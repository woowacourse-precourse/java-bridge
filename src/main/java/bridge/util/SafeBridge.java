package bridge.util;

public enum SafeBridge {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String letter;

    SafeBridge(int number, String letter) {
        this.number = number;
        this.letter = letter;
    }

    public static String chooseUpOrDown(int randomNumber) {
        if (randomNumber == SafeBridge.UP.number) {
            return SafeBridge.UP.letter;
        }
        return SafeBridge.DOWN.letter;
    }

    public static boolean isUp(String input) {
        return input.equals(SafeBridge.UP.letter);
    }

    public static boolean isDown(String input) {
        return input.equals(SafeBridge.DOWN.letter);
    }
}
