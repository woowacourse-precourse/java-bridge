package bridge;

public class BridgeElement {
    private final Character element;

    public BridgeElement(String element) {
        this.element = element.charAt(0);
    }

    public Character getElement() {
        return element;
    }
}
