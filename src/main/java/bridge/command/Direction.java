package bridge.command;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private final String text;
    private final int number;

    private Direction(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public int getNumber() {
        return this.number;
    }

    public static String convert(int direction) {
        if (direction == Direction.UP.getNumber()) {
            return Direction.UP.getText();
        }

        return Direction.DOWN.getText();
    }

    public static int convert(String direction) {
        if (direction.equals(Direction.UP.getText())) {
            return Direction.UP.getNumber();
        }

        return Direction.DOWN.getNumber();
    }

    public static boolean contains(int number) {
        for (Direction i : Direction.values()) {
            if (i.getNumber() == number) {
                return true;
            }
        }

        return false;
    }

    public static boolean contains(String text) {
        for (Direction i : Direction.values()) {
            if (i.getText().equals(text)) {
                return true;
            }
        }

        return false;
    }
}
