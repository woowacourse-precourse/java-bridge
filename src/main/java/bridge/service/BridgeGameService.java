package bridge.service;

import bridge.domain.Command;
import bridge.domain.bridge.Move;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameProgress;
import bridge.domain.game.GameStatus;
import bridge.dto.MapDto;
import bridge.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.domain.Command.RETRY;
import static bridge.domain.game.GameStatus.FAILED;
import static bridge.support.MapConst.BLANK;
import static bridge.support.MapConst.BRIDGE_UNIT_DELIMITER;
import static bridge.support.MapConst.SYMBOL_FAIL;
import static bridge.support.MapConst.MAP_FORMAT;
import static bridge.support.MapConst.SYMBOL_SUCCESS;
import static bridge.support.MapConst.SYMBOL_FORMAT;

public class BridgeGameService {

    private final BridgeGame bridgeGame;

    public BridgeGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public GameStatus crossBridgeUnit(String moving) {
        return bridgeGame.move(moving);
    }

    public GameStatus executeGameCommand(String code) {
        Command command = Command.from(code);
        return executeIfRetry(command);
    }

    private GameStatus executeIfRetry(Command command) {
        if (RETRY.equals(command)) {
            return bridgeGame.retry();
        }
        return FAILED;
    }

    public ResultDto getResultDto(GameStatus status) {
        return new ResultDto(status, bridgeGame.getAttempt(), getMapDto());
    }

    //TODO
    //gapeProgress 래핑하고 메서드 이동
    public MapDto getMapDto() {
        List<GameProgress> gameProgress = bridgeGame.getGameProgress();
        String upSide = toMapSide(gameProgress, Move.UP);
        String downSide = toMapSide(gameProgress, Move.DOWN);
        return new MapDto(String.format(MAP_FORMAT, upSide, downSide));
    }

    private String toMapSide(List<GameProgress> gameProgress, Move move) {
        List<String> results = gameProgress.stream()
                .map(progress -> getMapSideUnit(progress, move))
                .collect(Collectors.toList());
        return String.join(BRIDGE_UNIT_DELIMITER, results);
    }

    private String getMapSideUnit(GameProgress progress, Move move) {
        if (move.equals(progress.getMove())) {
            return String.format(SYMBOL_FORMAT, getSymbol(progress.isSuccess()));
        }
        return BLANK;
    }

    private String getSymbol(boolean success) {
        if (success) {
            return SYMBOL_SUCCESS;
        }
        return SYMBOL_FAIL;
    }
}
