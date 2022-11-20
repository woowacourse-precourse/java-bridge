package bridge.dto;

import bridge.domain.bridgegame.BridgeGame;

import java.util.List;

public class BridgeGameDto {
    private final List<String> upperBridgeMap;
    private final List<String> lowerBridgeMap;

    private BridgeGameDto(List<String> upperBridgeMap, List<String> lowerBridgeMap) {
        this.upperBridgeMap = upperBridgeMap;
        this.lowerBridgeMap = lowerBridgeMap;
    }

    public static BridgeGameDto from(List<String> upperBridgeMap, List<String> lowerBridgeMap) {
        return new BridgeGameDto(upperBridgeMap, lowerBridgeMap);
    }

    public BridgeGame toEntity() {
        return BridgeGame.from(upperBridgeMap, lowerBridgeMap);
    }
}
