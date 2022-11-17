package bridge.domain;

import bridge.dto.PlayerBridgeSizeDto;

public class Player {
    private final int bridgeSize;

    public Player(PlayerBridgeSizeDto playerBridgeSizeDto) {
        this.bridgeSize = playerBridgeSizeDto.getBridgeSize();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
