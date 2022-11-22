package bridge.enums;

public enum DorU {

    UP("U", 1),
    DOWN("D", 0);

    private final String name;
    private final Integer number;

    DorU(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public static String numberConvertUpAndDown(int object) {
        if (object == DOWN.number) {
            return DOWN.name;
        }
        return UP.name;
    }
}
