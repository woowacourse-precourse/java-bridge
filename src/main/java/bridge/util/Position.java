package bridge.util;

public enum Position {
    UP("U", 1),
    DOWN("D", 0);

    private final String initial;
    private final int number;

    Position(String initial, int number) {
        this.initial = initial;
        this.number = number;
    }

    public String getInitial() {
        return initial;
    }

    public int getNumber() {
        return number;
    }


}