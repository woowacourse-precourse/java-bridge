package bridge.model;

public enum Space {
    U("U"),
    D("D");

    private final String value;

    Space(String value) {
        this.value = value;
    }

    public static Space from(int numberOfRow) {
        if (numberOfRow == 1) {
            return Space.U;
        }
        return Space.D;
    }

    public String getValue() {
        return value;
    }

    public Space cross() {
        if (this.equals(Space.U)) {
            return Space.D;
        }
        return Space.U;
    }
}