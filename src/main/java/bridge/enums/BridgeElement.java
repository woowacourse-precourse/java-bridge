package bridge.enums;

public enum BridgeElement {
    BRIDGE_STARTING_ELEMENT("["),
    BRIDGE_SEPARATOR_ELEMENT("|"),
    BRIDGE_EMPTY_ELEMENT(" "),
    BRIDGE_ENDING_ELEMENT("]"),
    ;
    private final String element;

    BridgeElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element;
    }
}

