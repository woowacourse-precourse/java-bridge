package bridge.domain;

import static bridge.constant.BridgeConstant.RESTART_GAME;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeGameRepository bridgeGameRepository = new BridgeGameRepository();

    public Bridge getBridge(int size) {
        bridgeGameRepository.setBridgeGameInfo(size);
        List<String> blocks = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        return new Bridge(blocks);
    }

    public MoveResult move(Bridge bridge,
                           String moveMessage) {
        boolean isSuccess = bridge.isMoveSuccess(bridgeGameRepository.findRound(), moveMessage);
        return new MoveResult(moveMessage, isSuccess);
    }

    public boolean retry(String retryMessage) {
        if (retryMessage.equals(RESTART_GAME)) {
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
