package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final List<String> bridge;
    private List<Choice> inputs;
    private int index;

    public BridgeGame(int size){
        inputView = new InputView();
        outputView = new OutputView();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        init();
    }

    /**
     * 게임을 처음 시작하거나 재시작할 때 초기화 되어야 하는 값을 초기화해준다.
     */
    public void init(){
        index = 0;
        inputs = new ArrayList<Choice>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        String userInput = inputView.readMoving();
        boolean result = checkBridge(userInput);

        addResult(userInput, result);

        outputView.printMap();

        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String userInput = inputView.readGameCommand();
        boolean result = checkRestart(userInput);

        init();

        return result;
    }

    private void addResult(String userInput, boolean result){
        String isRight = "X";
        if (result) isRight = "O";

        Choice choice = new Choice(userInput, isRight);
        inputs.add(choice);
    }

    private boolean checkBridge(String userInput){
        if (bridge.get(index++) == userInput){
            return true;
        }
        return false;
    }

    private boolean checkRestart(String userInput){
        if (userInput == "Q"){
            return false;
        }
        return true;
    }

    public boolean isFinish(){
        if (index == inputs.size()){
            return true;
        }
        return false;
    }
}
