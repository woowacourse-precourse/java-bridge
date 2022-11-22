package bridge.service;

import bridge.domain.Command;
import bridge.domain.BridgeGame;
import bridge.domain.GameProgress;
import bridge.domain.GameStatus;
import bridge.dto.MapDto;
import bridge.dto.ResultDto;

import static bridge.domain.Command.RETRY;

public class BridgeGameService {

    private final BridgeGame bridgeGame;
    private final MapService mapService;

    public BridgeGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.mapService = new MapService();
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
        String map = mapService.getMap(gameProgress);
        return new MapDto(map);
    }
}
