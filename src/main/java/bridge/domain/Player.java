package bridge.domain;

import bridge.dto.BridgeDto;
import bridge.dto.PlayerBridgeSizeDto;

import java.util.List;

public class Player {
    private final int bridgeSize;
    private final List<String> bridge;

    public Player(PlayerBridgeSizeDto playerBridgeSizeDto, BridgeDto bridgeDto) {
        this.bridgeSize = playerBridgeSizeDto.getBridgeSize();
        this.bridge = bridgeDto.getBridge();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public String getBridgeCorrectLocation(int location) {
        return bridge.get(location);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
