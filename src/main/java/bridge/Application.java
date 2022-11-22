package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    final private static Map<List<Integer>, State> rules = setRules();
    private static State currentState = State.INITIAL_STATE;
    private static BridgeGame bg;
    final private static InputView in = new InputView();
    final private static OutputView out = new OutputView();

    public static void main(String[] args) {
        while (!currentState.end) {
            try {
                System.out.println(currentState.name());
                currentState.routine();
            } catch (Exception e) {
                dispatch(TRIGGER.INPUT_INVALID);
                System.out.println(e.getMessage());
            }
        }
    }

    private static void dispatch(TRIGGER trigger) {
        currentState = rules.get(List.of(currentState.ordinal(), trigger.ordinal()));
    }

    private static void dispatch2(TRIGGER trigger, boolean result) {
        currentState = rules.get(List.of(currentState.ordinal(), trigger.ordinal()));
        currentState.result = result;
    }


    private enum State {
        INITIAL_STATE {
            public void routine() {
                int bridgeSize = in.readBridgeSize();
                bg = new BridgeGame(out, bridgeSize);
                currentState = State.SELECTION_STATE;
                currentState.end = false;
            }
        },
        SELECTION_STATE {
            public void routine(){
                String direction = in.readMoving();
                boolean result = bg.move(direction);
                dispatch2(TRIGGER.INPUT_VALID, result);
            }
        },
        SUCCESS_TEST_STATE{
            public void routine(){
                System.out.println(currentState.result);
                if (!currentState.result) {
                    dispatch(TRIGGER.SELECTION_FAILURE);
                    return;
                }
                if(bg.isFinished()){
                    dispatch(TRIGGER.FINAL_SUCCESS);
                    return;
                }
                dispatch(TRIGGER.SELECTION_SUCCESS);
            }

        }, FINISH_TEST_STATE{
            public void routine(){

                if ( !bg.isFinished() && in.readGameCommand()) {
                    bg.retry();
                    dispatch(TRIGGER.CONTINUE);
                    return;
                }
                dispatch(TRIGGER.FINISH);
            }
        }, END{
            public void routine(){
                bg.finish();
                currentState.end = true;
            }
        };

        boolean result;
        boolean end;
        public abstract void routine();
    }

    private enum TRIGGER {
        INPUT_VALID, INPUT_INVALID, SELECTION_FAILURE, SELECTION_SUCCESS, FINAL_SUCCESS, CONTINUE, FINISH
    }

    private static Map<List<Integer>, State> setRules() {
        Map<List<Integer>, State> result = new HashMap<>();
        setInitialStateRules(result);
        setSelectionStateRules(result);
        setSuccessTestStateRules(result);
        setFinishStateRules(result);
        return result;
    }

    private static void setInitialStateRules(Map<List<Integer>, State> rules) {
        rules.put(List.of(State.INITIAL_STATE.ordinal(), TRIGGER.INPUT_INVALID.ordinal()),
                State.INITIAL_STATE);
    }

    private static void setSelectionStateRules(Map<List<Integer>, State> rules) {
        rules.put(List.of(State.SELECTION_STATE.ordinal(), TRIGGER.INPUT_INVALID.ordinal()),
                State.SELECTION_STATE);
        rules.put(List.of(State.SELECTION_STATE.ordinal(), TRIGGER.INPUT_VALID.ordinal()),
                State.SUCCESS_TEST_STATE);
    }

    private static void setSuccessTestStateRules(Map<List<Integer>, State> rules) {
        rules.put(List.of(State.SUCCESS_TEST_STATE.ordinal(), TRIGGER.INPUT_INVALID.ordinal()),
                State.SUCCESS_TEST_STATE);
        rules.put(List.of(State.SUCCESS_TEST_STATE.ordinal(), TRIGGER.SELECTION_FAILURE.ordinal()),
                State.FINISH_TEST_STATE);
        rules.put(List.of(State.SUCCESS_TEST_STATE.ordinal(), TRIGGER.SELECTION_SUCCESS.ordinal()),
                State.SELECTION_STATE);
        rules.put(List.of(State.SUCCESS_TEST_STATE.ordinal(), TRIGGER.FINAL_SUCCESS.ordinal()),
                State.FINISH_TEST_STATE);
    }

    private static void setFinishStateRules(Map<List<Integer>, State> rules) {
        rules.put(List.of(State.FINISH_TEST_STATE.ordinal(), TRIGGER.INPUT_INVALID.ordinal()),
                State.FINISH_TEST_STATE);
        rules.put(List.of(State.FINISH_TEST_STATE.ordinal(), TRIGGER.CONTINUE.ordinal()),
                State.SELECTION_STATE);
        rules.put(List.of(State.FINISH_TEST_STATE.ordinal(), TRIGGER.FINISH.ordinal()),
                State.END);
    }


}
