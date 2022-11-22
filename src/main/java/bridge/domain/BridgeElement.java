package bridge.domain;

public enum BridgeElement {
    START("[ "),
    END(" ]"),
    NOT_ACCESS(" "),
    POSSIBLE("O"),
    IMPOSSIBLE("X"),
    SEPARATOR(" | ");

    private final String element;

    BridgeElement(String element) {
        this.element = element;
    }

    public static StringBuilder addElement(StringBuilder bridge) {
        if (bridge.length() != 0) {
            bridge.append(SEPARATOR.element);
        }

        return bridge.append(NOT_ACCESS.element);
    }

    public static StringBuilder addElement(StringBuilder bridge, boolean result) {
        if (bridge.length() != 0) {
            bridge.append(SEPARATOR.element);
        }

        if (result) {
            return bridge.append(POSSIBLE.element);
        }
        return bridge.append(IMPOSSIBLE.element);
    }

    public static StringBuilder build(StringBuilder contents) {
        StringBuilder result = new StringBuilder(START.element);
        result.append(contents);
        result.append(END.element);
        return result;
    }
}


