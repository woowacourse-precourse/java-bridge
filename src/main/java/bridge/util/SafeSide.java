package bridge.util;

public enum SafeSide {

    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String letter;

    SafeSide(int number, String letter) {
        this.number = number;
        this.letter = letter;
    }

    public static String chooseUpOrDown(int number) {
        if (number == SafeSide.UP.number) {
            return SafeSide.UP.letter;
        }
        return SafeSide.DOWN.letter;
    }
}
