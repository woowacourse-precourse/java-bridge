package bridge.model;

public enum Direction {
    DOWN("D", 0),
    UP("U", 1);

    private final String firstLetter;
    private final int number;

    Direction(String firstLetter, int number) {
        this.firstLetter = firstLetter;
        this.number = number;
    }

    public static boolean isEqualToDown(String input) {
        return DOWN.firstLetter
                .equals(input);
    }

    public static boolean isEqualToUp(String input) {
        return UP.firstLetter
                .equals(input);
    }

    public static String getFirstLetterByNumber(int number) {
        for (Direction direction : Direction.values()) {
            if (number == direction.number) {
                return direction.firstLetter;
            }
        }
        return null;
    }

    public static String getFirstLetterByName(Direction direction) {
        return direction.firstLetter;
    }

}
