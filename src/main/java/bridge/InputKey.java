package bridge;

public enum InputKey {
    U("U"), D("D"), R("R"), Q("Q");

    private final String value;

    InputKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
