package bridge.dto;

import bridge.domain.bridgegame.BridgeGame;

import java.util.List;

public class BridgeGameDto {
    private final List<String> bridge;

    private BridgeGameDto(List<String> bridge) {
        this.bridge = bridge;
    }

    public static BridgeGameDto from(List<String> bridge) {
        return new BridgeGameDto(bridge);
    }

    public BridgeGame toEntity() {
        return BridgeGame.from(bridge);
    }
}
