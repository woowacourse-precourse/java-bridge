package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private String movable;
    private int result;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        this.movable = markMovable(moving);
        bridge.writeResult(moving, movable);
        bridge.movePosition();
        this.result = findResult();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.bridge.initBridge();
    }

    public boolean isMovable(String moving) {
        return bridge.canMove(moving);
    }

    public String markMovable(String moving) {
        if (isMovable(moving)) {
            return "O";
        }
        return "X";
    }

    public int isEnded() {
        return result;
    }

    public int findResult() {
        if (bridge.isArrived() && !bridge.failed()) {
            return Utils.SUCCESS;
        }
        if (bridge.failed()) {
            return Utils.FAIL;
        }
        return Utils.CONTINUE;
    }

    public String report() {
        return bridge.toString();
    }
}
