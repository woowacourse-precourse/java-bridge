package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.value.BridgeSize;
import bridge.domain.value.GameStatus;
import bridge.domain.value.MovingShape;

import java.util.List;

import static bridge.domain.BridgeGameCount.initBridgeGameCount;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMoving bridgeMoving;
    private final BridgeGameCount bridgeGameCount;
    private final BridgeIndex bridgeIndex;
    private final BridgeGameResult bridgeGameResult;
    private GameStatus gameStatus;

    public BridgeGame(BridgeSize bridgeSize) {
        this.bridgeIndex = new BridgeIndex();
        this.bridgeMoving = initBridgeMoving(bridgeSize, bridgeIndex);
        this.bridgeGameCount = initBridgeGameCount();
        this.bridgeGameResult = new BridgeGameResult();
        this.gameStatus = GameStatus.RUNNING;
    }

    private BridgeMoving initBridgeMoving(BridgeSize bridgeSize, BridgeIndex bridgeIndex) {
        Bridge bridge = makeBridge(bridgeSize);
        return new BridgeMoving(bridge, bridgeIndex);
    }

    private Bridge makeBridge(BridgeSize bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        return new Bridge(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MovingShape movingShape) {
        String movingResult = bridgeMoving.move(movingShape);
        bridgeGameResult.putMovingResult(movingShape.getShape(), movingResult);
        this.gameStatus = GameStatus.of(bridgeMoving, movingResult);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeGameResult.clearResult();
        bridgeGameCount.increaseCount();
        bridgeIndex.reset();
        this.gameStatus = GameStatus.RUNNING;
    }

    public boolean isRunning() {
        return gameStatus.isRunning();
    }

    public boolean isRetryOrQuit() {
        return gameStatus.isFail();
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }

    public BridgeGameCount getBridgeGameCount() {
        return bridgeGameCount;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
