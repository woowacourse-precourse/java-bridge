package bridge.domain;

public enum BridgeIdentifier {

    UP("U", 1),
    DOWN("D", 0);

    private final String valueOfString;
    private final int valueOfInt;

    BridgeIdentifier(String valueOfString, int valueOfInt) {
        this.valueOfString = valueOfString;
        this.valueOfInt = valueOfInt;
    }
}
