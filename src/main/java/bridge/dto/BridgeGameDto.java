package bridge.dto;

import bridge.domain.bridgegame.BridgeGame;

import java.util.List;

public class BridgeGameDto {
    private final List<String> gameMap;

    private BridgeGameDto(List<String> gameMap) {
        this.gameMap = gameMap;
    }

    public static BridgeGameDto from(List<String> gameMap) {
        return new BridgeGameDto(gameMap);
    }

    public BridgeGame toEntity() {
        return BridgeGame.from(gameMap);
    }
}
