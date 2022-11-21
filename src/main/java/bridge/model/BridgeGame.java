package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        player = Player.init();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingResult move(Moving moving) {
        if (isSameMoving(moving)) {
            player.move();
            return MovingResult.of(moving, Result.SUCCESS);
        }
        return MovingResult.of(moving, Result.FAIL);
    }

    private boolean isSameMoving(Moving moving) {
        return bridge.isSameMovingAt(player.getCurrentPosition(), moving);
    }

    public Result getGameResult() {
        if (isCompleted()) {
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }

    private boolean isCompleted() {
        int endPoint = bridge.size();

        return player.isAt(endPoint);
    }

    public int getTrialCount() {
        return player.getTrialCount();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.retry();
    }
}
