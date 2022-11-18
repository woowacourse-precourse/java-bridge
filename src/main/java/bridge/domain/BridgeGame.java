package bridge.domain;

import bridge.model.Answer;
import bridge.model.Direction;
import bridge.model.ErrorMessage;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int step;

    BridgeGame(List<String> bridge){
        this.bridge = bridge;
        step = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Answer move(String input) {
        isValidDirection(input);
        String nextAnswer = bridge.get(step);
        if(input.equals(nextAnswer)){
            step++;
            return Answer.CORRECT;
        }
        return Answer.INCORRECT;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private void isValidDirection(String input){
        if(input.equals(Direction.DOWN.getInput())
                || input.equals(Direction.UP.getInput())){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION_VALUE.getOutput());
    }

}
