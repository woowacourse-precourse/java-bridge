package bridge.model.dto;

import java.util.List;

public class GameResultDto {
    private MapDto mapData;
    private int totalTrials;
    private String totalResult;

    public GameResultDto(MapDto mapData, int totalTrials, String totalResult) {
        this.mapData = mapData;
        this.totalTrials = totalTrials;
        this.totalResult = totalResult;
    }

    public MapDto getMapData() {
        return mapData;
    }

    public int getTotalTrials() {
        return totalTrials;
    }

    public String getTotalResult() {
        return totalResult;
    }
}
