package bridge.domain;

public class BridgeMap {
    private final StringBuilder map;

    public BridgeMap(StringBuilder map) {
        this.map = map;
    }

    public void concatComponent(String component) {
        this.map.append(component);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
