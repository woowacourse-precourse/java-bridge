package bridge.service;

import bridge.domain.Command;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameProgress;
import bridge.domain.game.GameStatus;
import bridge.domain.MapManager;
import bridge.dto.MapDto;
import bridge.dto.ResultDto;

import static bridge.domain.Command.RETRY;

public class BridgeGameService {

    private final BridgeGame bridgeGame;
    private final MapManager mapManager;

    public BridgeGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.mapManager = new MapManager();
    }

    public GameStatus crossBridgeUnit(String moving) {
        return bridgeGame.move(moving);
    }

    public boolean executeIfRetry(Command command) {
        if (RETRY.equals(command)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    public ResultDto getResultDto(GameStatus status) {
        return new ResultDto(status, bridgeGame.getAttempt(), getMapDto());
    }

    public MapDto getMapDto() {
        GameProgress gameProgress = bridgeGame.getGameProgress();
        String map = mapManager.getMap(gameProgress);
        return new MapDto(map);
    }
}
