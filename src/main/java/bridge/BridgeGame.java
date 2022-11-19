package bridge;

import bridge.validator.InputType;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int START_STEP = 0;
    private List<String> bridge = new ArrayList<>();
    private int curStep = START_STEP;

    public void initGame(List<String> bridge) {
        curStep = START_STEP;
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public boolean move(String moving) {
        boolean correct = false;
        
        correct = isCorrect(moving);
        curStep++;

        return correct;
    }

    private boolean isCorrect(String moving) {
        return bridge.get(curStep).equals(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        return InputType.isRestartInput(gameCommand);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getCurStep() {
        return curStep;
    }
}
