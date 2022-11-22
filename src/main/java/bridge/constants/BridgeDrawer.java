package bridge.constants;

public enum BridgeDrawer {
    START_OF_BRIDGE("[ "),
    END_OF_BRIDGE(" ]"),
    DIVIDE_SPACE(" | "),
    EMPTY_SPACE(" ");

    private final String character;

    BridgeDrawer(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return this.character;
    }
}
