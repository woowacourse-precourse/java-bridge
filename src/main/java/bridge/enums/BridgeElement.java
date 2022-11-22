package bridge.enums;

/**
 * 다리를 출력할 때 필요한 요소이다.
 */
public enum BridgeElement {
    BRIDGE_STARTING_ELEMENT("["),
    BRIDGE_ENDING_ELEMENT("]"),
    BRIDGE_SEPARATOR_ELEMENT("|"),
    BRIDGE_EMPTY_ELEMENT(" "),
    BRIDGE_PASSABLE_ELEMENT("O"),
    BRIDGE_IMPASSABLE_ELEMENT("X"),
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

