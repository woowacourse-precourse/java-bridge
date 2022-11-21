package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String MOVING_SUCCESS = "O";
    private static final String RETRY = "R";

    private final BridgeMoving bridgeMoving;
    private final BridgeGameCount bridgeGameCount;
    private final BridgeGameResult bridgeGameResult;

    public BridgeGame(int size) {
        this.bridgeMoving = new BridgeMoving(makeBridge(size));
        this.bridgeGameCount = new BridgeGameCount();
        this.bridgeGameResult = new BridgeGameResult();
    }

    private Bridge makeBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, int movingIndex) {
        String movingResult = bridgeMoving.move(moving, movingIndex);
        bridgeGameResult.putMovingResult(moving, movingResult);
        return isMove(movingResult);
    }

    private boolean isMove(String movingResult) {
        return movingResult.equals(MOVING_SUCCESS);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (isRetry(gameCommand)) {
            bridgeGameResult.clearResult();
            increaseGameCount();
            return true;
        }
        return false;
    }

    private boolean isRetry(String gameCommand) {
        return gameCommand.equals(RETRY);
    }

    public void increaseGameCount() {
        bridgeGameCount.increaseCount();
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }

    public BridgeGameCount getBridgeGameCount() {
        return bridgeGameCount;
    }
}
