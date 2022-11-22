package bridge.domain;

public enum MovementType {
    UP(1, "U"),
    DOWN(0, "D");

    private final int index;
    private final String code;

    MovementType(int index, String code) {
        this.index = index;
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public int getIndex() {
        return this.index;
    }
}
