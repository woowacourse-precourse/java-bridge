package bridge.domain;

public enum BridgeFlag {
    SUCCESS("O"),
    FAIL("X"),
    NOTHING(" ");

    public final String flag;

    BridgeFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return flag;
    }
}
