package bridge.dto;

import bridge.domain.Player;

public class PlayerBridgeSizeDto {
    private final int bridgeSize;

    public PlayerBridgeSizeDto(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public static PlayerBridgeSizeDto from(Player player) {
        return new PlayerBridgeSizeDto(player.getBridgeSize());
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
