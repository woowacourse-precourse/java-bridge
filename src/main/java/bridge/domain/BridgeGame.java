package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.command.MoveCommand;
import bridge.domain.command.RetryCommand;
import bridge.dto.GameResult;
import bridge.dto.MoveResult;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeGameRepository bridgeGameRepository = new BridgeGameRepository();

    public Bridge getBridge(BridgeSize bridgeSize) {
        bridgeGameRepository.setBridgeGameInfo(bridgeSize);
        List<String> blocks = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize.getSize());
        return new Bridge(blocks);
    }

    public MoveResult move(Bridge bridge,
                           MoveCommand command) {
        int round = bridgeGameRepository.findRound();
        boolean isSuccess = bridge.isMoveSuccess(round, command.getMessage());
        return new MoveResult(command, isSuccess, round);
    }

    public boolean retry(RetryCommand retryCommand) {
        if (retryCommand.isRetry()) {
            bridgeGameRepository.retry();
            return true;
        }
        return false;
    }

    public boolean isGameClear() {
        if (bridgeGameRepository.isFinalRound()) {
            return true;
        }
        bridgeGameRepository.goToNextRound();
        return false;
    }

    public GameResult closeGame(MoveResult moveResult) {
        return new GameResult(bridgeGameRepository.findTryCount(), moveResult);
    }
}
