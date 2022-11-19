package bridge;

public enum BridgeResultString {

    PASS("   "), SUCCESS(" O "), FAILURE(" X "), NEXT("|");

    private final String string;

    BridgeResultString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
