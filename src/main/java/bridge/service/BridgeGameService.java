package bridge.service;

import bridge.domain.Command;
import bridge.domain.bridge.BridgeUnit;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameProgress;
import bridge.domain.game.GameStatus;
import bridge.dto.MapDto;
import bridge.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.domain.Command.RETRY;

public class BridgeGameService {

    private static final String MAP_FORMAT = "[%s]\n[%s]";
    private static final String BRIDGE_UNIT_DELIMITER = "|";
    private static final String SYMBOL = " %s ";
    private static final String BLANK = "   ";
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";

    private final BridgeGame bridgeGame;

    public BridgeGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public GameStatus crossBridgeUnit(String moving) {
        BridgeUnit nextUnit = BridgeUnit.from(moving);
        return bridgeGame.move(nextUnit);
    }

    public GameStatus readGameCommand(GameStatus status, String code) {
        Command command = Command.from(code);
        return invokeIfRetry(command, status);
    }

    private GameStatus invokeIfRetry(Command command, GameStatus status) {
        if (RETRY.equals(command)) {
            return bridgeGame.retry();
        }
        return status;
    }

    public ResultDto getResultDto(GameStatus status) {
        return new ResultDto(status, bridgeGame.getAttempt(), getMapDto());
    }

    public MapDto getMapDto() {
        List<GameProgress> gameProgress = bridgeGame.getGameProgress();
        String upSide = toMapSide(gameProgress, BridgeUnit.UP);
        String downSide = toMapSide(gameProgress, BridgeUnit.DOWN);
        return new MapDto(String.format(MAP_FORMAT, upSide, downSide));
    }

    private String toMapSide(List<GameProgress> gameProgress, BridgeUnit bridgeUnit) {
        List<String> results = gameProgress.stream()
                .map(progress -> getMapSideUnit(progress, bridgeUnit))
                .collect(Collectors.toList());
        return String.join(BRIDGE_UNIT_DELIMITER, results);
    }

    private String getMapSideUnit(GameProgress progress, BridgeUnit bridgeUnit) {
        if (bridgeUnit.equals(progress.getBridgeUnit())) {
            return String.format(SYMBOL, getSymbol(progress.isSuccess()));
        }
        return BLANK;
    }

    private String getSymbol(boolean success) {
        if (success) {
            return SUCCESS;
        }
        return FAIL;
    }
}
