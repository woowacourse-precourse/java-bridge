package bridge.dto;

public class ResultDTO {
    private final MapDTO map;
    private final boolean success;
    private final int count;

    public ResultDTO(MapDTO map, boolean success, int count) {
        this.map = map;
        this.success = success;
        this.count = count;
    }

    public MapDTO getMap() {
        return map;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCount() {
        return count;
    }
}
