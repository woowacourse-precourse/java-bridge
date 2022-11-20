package bridge.domain.user;

public enum CurrentBridgeElement {
    HEAD("["),
    TAIL("]"),
    DELIMITER("|"),
    BLANK(" "),
    CROSS_SUCCEEDED("O"),
    CROSS_FAILED("X");

    private final String element;

    CurrentBridgeElement(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
