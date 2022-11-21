package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String CAN_PASS = "O";
    private static final String CANNOT_PASS = "X";
    private static final String QUIT = "Q";
    private final List<String> bridge;
    private List<Choice> inputs;
    private int index;

    public BridgeGame(int size){
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        init();
    }

    /**
     * 게임을 처음 시작하거나 재시작할 때 초기화 되어야 하는 값을 초기화해준다.
     */
    public void init(){
        index = 0;
        inputs = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userInput) {
        boolean result = checkBridge(userInput);
        addResult(userInput, result);
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        boolean result = checkRestart(userInput);

        init();

        return result;
    }

    private void addResult(String userInput, boolean result){
        String isRight = CANNOT_PASS;
        if (result) isRight = CAN_PASS;

        inputs.add(new Choice(userInput, isRight));
    }

    private boolean checkBridge(String userInput){
        if (bridge.get(index).equals(userInput)){
            index++;
            return true;
        }
        return false;
    }

    private boolean checkRestart(String userInput){
        if (userInput.equals(QUIT)){
            return false;
        }
        return true;
    }

    public boolean isFinish(){
        if (index == bridge.size()){
            return true;
        }
        return false;
    }

    public List<Choice> getInputs(){
        return inputs;
    }
}
