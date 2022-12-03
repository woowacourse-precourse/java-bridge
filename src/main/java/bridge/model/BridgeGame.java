package bridge.model;


import java.util.ArrayList;
import java.util.List;

import static bridge.utils.ErrorMessage.INVALID_MOVING;
import static bridge.utils.ErrorMessage.INVALID_RETRY;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<Step> steps = new ArrayList<>();
    private int stepCount;
    private Result result;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.stepCount = 0;
        this.result = new Result();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        validateDirection(direction);
        String safeZone = bridge.get(stepCount);
        Step step = Step.of(safeZone, direction);
        steps.add(step);
        stepCount++;
        result.setSteps(steps);
        return isSafe();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        validateGameCommand(gameCommand);
        if (gameCommand.equals("Q")) {
            return false;
        }
        initialize();
        return true;
    }

    public List<Step> getSteps() {
        return this.steps;
    }

    public boolean isSuccess() {
        if (steps.size() == bridge.size()) {
            result.setIsSuccess(true);
            return true;
        }
        return false;
    }

    public Result getResult() {
        return this.result;
    }

    private boolean isSafe() {
        return getLastStep().name().contains("SUCCESS");
    }

    private Step getLastStep() {
        return this.steps.get(steps.size() - 1);
    }

    private void initialize() {
        this.stepCount = 0;
        this.steps.clear();
        result.clear();
    }

    private void validateDirection(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException(INVALID_MOVING.message);
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException(INVALID_RETRY.message);
        }
    }

}
