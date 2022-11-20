package bridge.domain;

public enum Moving {

    UP("U", 1),
    DOWN("D", 0);

    private final String value;
    private final int number;

    Moving(String value, int number) {
        this.value = value;
        this.number = number;
    }

    String getValue() {
        return value;
    }

    int getNumber() {
        return number;
    }
}
