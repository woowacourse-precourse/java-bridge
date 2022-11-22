package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int ZERO_COUNT = 0;
    private int tryCount;
    private final Bridge bridge;
    private CurrentBridgeMap currentBridgeMap;
    private PlayerMovement playerMovement;

    public BridgeGame(Bridge bridge) {
        tryCount = 1;
        this.bridge = bridge;
        currentBridgeMap = new CurrentBridgeMap();
        playerMovement = new PlayerMovement();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String inputValue) {
        playerMovement.addMovement(inputValue);
        return currentBridgeMap.getCurrentBridgeMap(inputValue, isAllEqualSoFar());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        currentBridgeMap = new CurrentBridgeMap();
        playerMovement = new PlayerMovement();
    }

    private boolean isAllEqualSoFar() {
        return bridge.isAllEqualSoFar(playerMovement.getMovement());
    }

    public boolean isFinish() {
        if (isEndBridge()) {
            return true;
        }
        if (playerMovement.getMovementCount() == ZERO_COUNT) {
            return false;
        }

        return !isAllEqualSoFar();
    }

    private boolean isEndBridge() {
        return bridge.getBridgeSize() == playerMovement.getMovementCount();
    }

    public boolean isSuccess() {
        return bridge.isEqual(playerMovement.getMovement());
    }

    public int getTryCount() {
        return tryCount;
    }
}
