package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    final private Map<List<Integer>, State> rules = setRules();
    private State currentState;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


    private enum State {
        INITIAL_STATE, SELECTION_STATE, SUCCESS_TEST_STATE, FINISH_TEST_STATE, END
    }

    private enum TRIGGER {
        INPUT_VALID, INPUT_INVALID, SELECTION_FAILURE, SELECTION_SUCCESS, CONTINUE, FINISH
    }

    private Map<List<Integer>, State> setRules() {
        Map<List<Integer>, State> result = new HashMap<>();
        setSelectionStateRules(result);
        setSuccessTestStateRules(result);
        setFinishStateRules(result);
        return result;
    }

    private void setSelectionStateRules(Map<List<Integer>, State> rules){
        rules.put(List.of(State.SELECTION_STATE.ordinal(), TRIGGER.INPUT_INVALID.ordinal()),
                State.SELECTION_STATE);
        rules.put(List.of(State.SELECTION_STATE.ordinal(), TRIGGER.INPUT_VALID.ordinal()),
                State.SUCCESS_TEST_STATE);
    }
    private void setSuccessTestStateRules(Map<List<Integer>, State> rules){
        rules.put(List.of(State.SUCCESS_TEST_STATE.ordinal(), TRIGGER.SELECTION_FAILURE.ordinal()),
                State.SELECTION_STATE);
        rules.put(List.of(State.SUCCESS_TEST_STATE.ordinal(), TRIGGER.SELECTION_SUCCESS.ordinal()),
                State.FINISH_TEST_STATE);
    }
    private void setFinishStateRules(Map<List<Integer>, State> rules){
        rules.put(List.of(State.FINISH_TEST_STATE.ordinal(), TRIGGER.CONTINUE.ordinal()),
                State.SELECTION_STATE);
        rules.put(List.of(State.FINISH_TEST_STATE.ordinal(), TRIGGER.FINISH.ordinal()),
                State.END);
    }

}
