package bridge.dto;

import bridge.domain.GameData;

public class HistoryMapDto {
    private final String historyMap;

    public HistoryMapDto(String historyMap) {
        this.historyMap = historyMap;
    }

    public static HistoryMapDto from(GameData gameData) {
        return new HistoryMapDto(gameData.getHistoryMap());
    }

    public String getHistoryMap() {
        return historyMap;
    }
}
