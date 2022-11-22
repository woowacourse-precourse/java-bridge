package bridge.model.domains;

/**
 * 게임 사용자의 상태(아직 건너야 할 다리 칸 정보, 현재 생존 여부)를 관리하는 클래스
 */
public class Player {

    private final RemainingSteps remainingSteps;
    private boolean isFailed = false;

    public Player(RemainingSteps steps) {
        this.remainingSteps = steps;
    }

    public void addOneMoving(String moving) throws IllegalStateException {
        validateStatus();
        isFailed = !remainingSteps.isMovableStep(moving);
    }

    private void validateStatus() {
        if (remainingSteps.isEmpty()) {
            throw new IllegalStateException("사용자가 이미 다리를 모두 건넜습니다.");
        }
        if (isFailed) {
            throw new IllegalStateException("이미 다리 건너기를 실패했습니다.");
        }
    }

    public boolean isFailed() {
        return isFailed;
    }

    public boolean hasAllMovingDone() {
        return remainingSteps.isEmpty();
    }
}
