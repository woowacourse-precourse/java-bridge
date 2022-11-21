package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final int STARTING_POINT = 0;
    public static final int FIRST_TRIAL = 1;

    private final Bridge bridge;
    private int currentPosition;
    private int trialCount;

    public BridgeGame(Bridge bridge) {
        currentPosition = STARTING_POINT;
        trialCount = FIRST_TRIAL;
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingResult move(Moving moving) {
        if (isSameMoving(moving)) {
            currentPosition++;
            return MovingResult.of(moving, Result.SUCCESS);
        }
        return MovingResult.of(moving, Result.FAIL);
    }

    private boolean isSameMoving(Moving moving) {
        return bridge.isSameMovingAt(currentPosition, moving);
    }

    public Result getGameResult() {
        if (isCompleted()) {
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }

    private boolean isCompleted() {
        return bridge.size() == currentPosition;
    }

    public int getTrialCount() {
        return trialCount;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        trialCount++;
        currentPosition = STARTING_POINT;
    }
}
