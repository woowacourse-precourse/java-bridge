package bridge.dto;

import bridge.domain.GameData;

public class PlayerLocationDto {
    private final int location;

    public PlayerLocationDto(int location) {
        this.location = location;
    }

    public static PlayerLocationDto from(GameData gameData) {
        return new PlayerLocationDto(gameData.getLocation());
    }

    public int getLocation() {
        return location;
    }
}
