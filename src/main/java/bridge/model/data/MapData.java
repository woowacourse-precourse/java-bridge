package bridge.model.data;

public class MapData {
    private String upsideMap;
    private String downsideMap;

    public MapData(String upsideMap, String downsideMap) {
        this.upsideMap = upsideMap;
        this.downsideMap = downsideMap;
    }

    public String getUpsideMap() {
        return upsideMap;
    }

    public String getDownsideMap() {
        return downsideMap;
    }
}