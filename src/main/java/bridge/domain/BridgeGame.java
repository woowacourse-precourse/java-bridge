package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.command.MoveCommand;
import bridge.domain.command.RetryCommand;
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
        boolean isSuccess = bridge.isMoveSuccess(bridgeGameRepository.findRound(), command.getMessage());
        return new MoveResult(command, isSuccess);
    }

    //ENUM ?
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

    public GameResult closeGame() {
        return new GameResult(bridgeGameRepository.findTryCount(),
                bridgeGameRepository.isFinalRound());
    }
}
