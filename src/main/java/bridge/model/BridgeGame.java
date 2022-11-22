package bridge.model;

import bridge.BridgeMaker;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private Bridge bridge;
    private BridgeResult bridgeResult;
    private ResultFlag resultFlag;
    private int tryCount = 1;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void create(int bridgeSize) {
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        bridgeResult = new BridgeResult(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userMovingCommand) {
        resultFlag = bridgeResult.move(userMovingCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeResult.reset();
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public BridgeResult getMap() {
        return bridgeResult;
    }

    public ResultFlag getResultFlag() {
        return resultFlag;
    }

    public boolean completion() {
        return bridge.getSize() == bridgeResult.getCrossingCount();
    }
}
