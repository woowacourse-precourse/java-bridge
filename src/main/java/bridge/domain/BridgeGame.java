package bridge.domain;

import bridge.domain.generator.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.MoveCommand;
import bridge.domain.vo.RetryCommand;
import bridge.dto.GameResult;
import bridge.dto.MoveResult;
import java.util.List;

public class BridgeGame {

    private final BridgeGameRepository bridgeGameRepository = new BridgeGameRepository();

    public Bridge getBridge(BridgeSize bridgeSize) {
        bridgeGameRepository.setBridgeGameInfo(bridgeSize);
        List<String> blocks = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize.getSize());
        return new Bridge(blocks);
    }

    public MoveResult move(Bridge bridge,
                           MoveCommand command) {
        String message = command.getMessage();
        int round = bridgeGameRepository.findRound();
        boolean isSuccess = bridge.isMoveSuccess(round, message);
        return new MoveResult(message, isSuccess, round);
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
