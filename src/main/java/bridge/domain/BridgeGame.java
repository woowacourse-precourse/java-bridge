package bridge.domain;

import bridge.domain.constant.ResultMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final NumberOfTry numberOfTry = new NumberOfTry();
    private Bridge bridge;
    private BridgeGameResult bridgeGameResult;
    private int currentPosition;

    public BridgeGame(Bridge bridge) {
        initBridgeGame(bridge);
    }

    private void initBridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.bridgeGameResult = new BridgeGameResult();
        this.currentPosition = -1;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getNumberOfTry() {
        return numberOfTry.getCount();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        currentPosition++;
        bridgeGameResult.makeMoveResult(bridge, currentPosition, direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge) {
        numberOfTry.increaseCount();
        initBridgeGame(bridge);
    }

    public String getSuccessOrFailure() {
        if (currentPosition == bridge.getSize() - 1) {
            return ResultMessage.SUCCESS.toString();
        }
        return ResultMessage.FAILURE.toString();
    }
}
