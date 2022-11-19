package bridge.domain;

public enum ResultFlag {
    SUCCESS("O"),
    FAIL("X"),
    NOTHING(" ");

    private final String flag;

    ResultFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return flag;
    }
}
