package bridge.domain;

public enum BridgeMap {
    START("["),
    END("]"),
    CORRECT(" O |"),
    INCORRECT(" X ]"),
    BLANK("   |"),
    WIN("성공"),
    LOSE("실패");

    String element;

    public String getElement() {
        return element;
    }

    BridgeMap(String element) {
        this.element = element;
    }
}
