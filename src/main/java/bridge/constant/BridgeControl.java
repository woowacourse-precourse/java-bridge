package bridge.constant;

public enum BridgeControl {

    RESTART("R")
    , QUIT("Q");

    private final String identifier;

    BridgeControl(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
