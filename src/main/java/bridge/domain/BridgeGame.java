package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private int currentPosition;
    private BridgeGameResult bridgeGameResult;
    private int numberOfTry = 1;

    public BridgeGame(Bridge bridge) {
        initBridgeGame(bridge);
    }

    private void initBridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.currentPosition = -1;
        this.bridgeGameResult = new BridgeGameResult();
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        currentPosition++;
        bridgeGameResult.makeMoveResult(bridge, currentPosition, direction);
        return bridgeGameResult.getIsMoveFail();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge) {
        numberOfTry++;
        initBridgeGame(bridge);
    }

    public String getSuccessOrFailure() {
        if (currentPosition == bridge.getSize() - 1) {
            return ResultMessage.성공.name();
        }
        return ResultMessage.실패.name();
    }
}
