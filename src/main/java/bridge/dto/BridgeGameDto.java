package bridge.dto;

import bridge.domain.bridgegame.BridgeGame;

import java.util.HashMap;
import java.util.List;

public class BridgeGameDto {
    private final HashMap<String, List<String>> gameMap;

    private BridgeGameDto(HashMap<String, List<String>> gameMap) {
        this.gameMap = gameMap;
    }

    public static BridgeGameDto from(HashMap<String, List<String>> gameMap) {
        return new BridgeGameDto(gameMap);
    }

    public BridgeGame toEntity() {
        return BridgeGame.from(gameMap);
    }
}
