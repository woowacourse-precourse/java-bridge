package bridge.domain;

public class BridgeMap {

    private final StringBuilder map;

    public BridgeMap(StringBuilder map) {
        this.map = map;
    }

    public void appendComponent(String component) {
        map.append(component);
    }

    public void deleteLastComponent(String component) {
        this.map.deleteCharAt(this.map.lastIndexOf(component));
    }
}
