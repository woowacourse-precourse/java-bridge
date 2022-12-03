package bridge.model.map;

public class Maps {

    private final Map upMap;
    private final Map downMap;

    public Maps(Map upMap, Map downMap) {
        this.upMap = upMap;
        this.downMap = downMap;
    }

    public static Maps byInitialState() {
        return new Maps(Map.create(), Map.create());
    }
}
