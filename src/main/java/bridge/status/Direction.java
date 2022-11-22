package bridge.status;

public class Direction {


    enum DirectionSource {
        UP(1, "U"),

        DOWN(0, "D");

        private final String text;
        private final int number;

        private DirectionSource(int number, String text) {
            this.number = number;
            this.text = text;
        }

        private String getText() {
            return this.text;
        }

        private int getNumber() {
            return this.number;
        }
    }

    private Direction() {

    }

    public static String convert(int direction) {
        if (direction == DirectionSource.UP.getNumber()) {
            return DirectionSource.UP.getText();
        }

        return DirectionSource.DOWN.getText();
    }

    public static boolean contains(String text) {
        for (DirectionSource i : DirectionSource.values()) {
            if (i.getText().equals(text)) {
                return true;
            }
        }

        return false;
    }

    public static String getUpTextSource() {
        return DirectionSource.UP.getText();
    }

    public static String getDownTextSource() {
        return DirectionSource.DOWN.getText();
    }
}
