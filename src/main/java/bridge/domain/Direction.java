package bridge.domain;

public class Direction {
     public enum Code {
        UP(1, "U"), DOWN(0, "D");
        private final int number;
        private final String name;

        Code(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public String getName(){
            return name;
        }
    }

    private final String direction;

    public Direction(int number) {
        direction = toString(number);
    }

    private String toString(int number) {
        if (number == Code.DOWN.number) {
            return Code.DOWN.name;
        }
        if (number == Code.UP.number) {
            return Code.UP.name;
        }
        throw new IllegalArgumentException();
    }

    public String getDirection() {
        return direction;
    }
}
