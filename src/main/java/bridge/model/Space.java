package bridge.model;

public enum Space {
    U("U", 1),
    D("D", 0);

    private final String value;
    private final int index;

    Space(String value, int index) {
        this.value = value;
        this.index = index;
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
