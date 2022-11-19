package bridge;

public enum BridgeMap {
    CORRECT(" O |"),
    INCORRECT(" X ]"),
    BLANK("   |");
    String element;

    public String getElement() {
        return element;
    }

    BridgeMap(String element) {
        this.element = element;
    }
}
