package bridge.domain;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Direction;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeGameStatus bridgeGameStatus;

    public BridgeGame(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeAnswer = bridgeMaker.makeBridge(bridgeSize);
        this.bridgeGameStatus = new BridgeGameStatus(bridgeAnswer);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public BridgeGameStatus move(Direction direction) {
        bridgeGameStatus.move(direction);
        return bridgeGameStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        bridgeGameStatus.retry();
    }
}