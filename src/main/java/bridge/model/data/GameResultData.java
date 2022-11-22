package bridge.model.data;


public class GameResultData {
    private MapData mapData;
    private int totalTrials;
    private String totalResult;

    public GameResultData(MapData mapData, int totalTrials, String totalResult) {
        this.mapData = mapData;
        this.totalTrials = totalTrials;
        this.totalResult = totalResult;
    }

    public MapData getMapData() {
        return mapData;
    }

    public int getTotalTrials() {
        return totalTrials;
    }

    public String getTotalResult() {
        return totalResult;
    }
}