package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final int STARTING_POINT = 0;
    public static final int FIRST_TRIAL = 1;

    private int currentPosition;
    private int bridgeSize;
    private int trialCount;

    public BridgeGame(int bridgeSize) {
        currentPosition = STARTING_POINT;
        trialCount = FIRST_TRIAL;
        this.bridgeSize = bridgeSize;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingResult move(List<String> bridge, String moving) {
        validate(moving);
        String direction = bridge.get(currentPosition);

        if (direction.equals(moving)) {
            currentPosition++;
            return MovingResult.of(moving, Result.SUCCESS);
        }
        return MovingResult.of(moving, Result.FAIL);
    }

    private void validate(String moving) {
        if (moving.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BLANK_INPUT);
        }
        if (isValidMoving(moving)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING_INPUT);
        }
    }

    private static boolean isValidMoving(String moving) {
        return !moving.equals("U") && !moving.equals("D");
    }

    public Result getGameResult(MovingResult movingResult) {
        if (movingResult.isFail()) {
            return Result.FAIL;
        }
        if (bridgeSize == currentPosition) {
            return Result.SUCCESS;
        }
        return Result.IN_PROGRESS;
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
