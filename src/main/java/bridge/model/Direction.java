package bridge.model;

public enum Direction {
    DOWN("D", 0),
    UP("U", 1);

    private final String name;
    private final int value;

    Direction(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static boolean isDirection(String input){
        return input.equals(DOWN.getName()) || input.equals(UP.getName());
    }
}
