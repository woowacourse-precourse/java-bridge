package bridge;

import java.util.*;

import static bridge.Enum.Direction.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> scaffold;
    private final HashMap<String, List<String>> stepProgress = new HashMap<>();
    private int gameStep = 0;
    private boolean survive = true;

    public BridgeGame(List<String> bridgeScaffold) {
        this.scaffold = bridgeScaffold;
        initStepProgress();
    }

    private void initStepProgress() {
        this.stepProgress.put(UP.getInitial(), new ArrayList<>());
        this.stepProgress.put(DOWN.getInitial(), new ArrayList<>());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String direction) {
        checkStepResult(direction);

        List<String> movingProgress = getMovingProgress(direction);

        this.gameStep++;

        return movingProgress;
    }

    private void checkStepResult(String direction) {
        this.survive = direction.equals(this.scaffold.get(gameStep));
    }

    private List<String> getMovingProgress(String direction) {
        updateStepProgress(direction);

        String upDirectionProgress = getProgressOfDirection(UP.getInitial());
        String downDirectionProgress = getProgressOfDirection(DOWN.getInitial());

        return new ArrayList<>(List.of(upDirectionProgress, downDirectionProgress));
    }

    private String getOppositeDirection(String direction) {
        if (UP.getInitial().equals(direction)) {
            return DOWN.getInitial();
        }
        return UP.getInitial();
    }

    private void updateStepProgress(String direction) {
        String oppositeDirection = getOppositeDirection(direction);
        if (!this.survive) {
            this.stepProgress.get(direction).add("X");
            this.stepProgress.get(oppositeDirection).add(" ");
            return;
        }
        this.stepProgress.get(direction).add("O");
        this.stepProgress.get(oppositeDirection).add(" ");
    }

    private String getProgressOfDirection(String direction) {
        String progress = String.join(" | ", this.stepProgress.get(direction));
        return "[ " + progress + " ]";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initStepProgress();
        gameStep = 0;
    }
}
