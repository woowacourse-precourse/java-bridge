package bridge.service;

import bridge.domain.Command;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameProgress;
import bridge.domain.GameStatus;
import bridge.dto.MapDto;
import bridge.dto.ResultDto;

import static bridge.domain.Command.RETRY;

public class BridgeGameService {

    private final BridgeGame bridgeGame;

    public BridgeGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public GameStatus crossBridgeUnit(String moving) {
        bridgeGame.move(moving);
        return bridgeGame.getGameResult();
    }

    public boolean isPlaying() {
        return bridgeGame.isPlaying();
    }

    public boolean executeGameCommand(String code) {
        Command command = Command.from(code);
        return executeIfRetry(command);
    }

    private boolean executeIfRetry(Command command) {
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
        return new MapDto(gameProgress.getMap());
    }
}
