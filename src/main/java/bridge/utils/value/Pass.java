package bridge.utils.value;

public enum Pass {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String passable;

    Pass(int number, String passable) {
        this.number = number;
        this.passable = passable;
    }

    public static String getPassableByNumber(int number) {
        if (number == DOWN.number) {
            return DOWN.passable;
        }
        return UP.passable;
    }
}
