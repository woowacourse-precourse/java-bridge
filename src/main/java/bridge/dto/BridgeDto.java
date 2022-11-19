package bridge.dto;

import bridge.domain.Player;

import java.util.List;

public class BridgeDto {
    private final List<String> bridge;

    public BridgeDto(List<String> bridge) {
        this.bridge = bridge;
    }

    public static BridgeDto from(Player player) {
        return new BridgeDto(player.getBridge());
    }

    public List<String> getBridge() {
        return bridge;
    }
}
