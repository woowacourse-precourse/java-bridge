package bridge.dto;

import bridge.domain.GameData;

public class PlayerTryCountDto {
    private final int tryCount;

    public PlayerTryCountDto(int tryCount) {
        this.tryCount = tryCount;
    }

    public static PlayerTryCountDto from(GameData gameData) {
        return new PlayerTryCountDto(gameData.getTryCount());
    }

    public int getTryCount() {
        return tryCount;
    }
}
