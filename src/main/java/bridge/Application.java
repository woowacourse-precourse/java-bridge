package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    final private Map<List<Integer>, State> rules = setRules();
    private State currentState;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
