package bridge.model.dto;

public class MapDto {

    private String upsideMap;
    private String downsideMap;

    public MapDto(String upsideMap, String downsideMap) {
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
