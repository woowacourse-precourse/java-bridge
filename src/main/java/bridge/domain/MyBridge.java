package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MyBridge {

    private List<String> inputList;
    private List<String> answerBridge;

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public MyBridge(List<String> answerBridge) {
        this.inputList = new ArrayList<>();
        this.answerBridge = answerBridge;
    }


    public boolean matchBlocks() {
        int size = inputList.size();
        if (size == 0) {
            return true;
        }
        if (compareBridgeBlock(size-1)) {
            return true;
        }
        return false;
    }

    public boolean matchLength() {
        return inputList.size() == answerBridge.size();
    }

    public void inputAlphabet() {
        String input = inputView.readMoving();
        validateMove(input);
        addInputList(input);
    }
    private void validateMove(String input) {
        if (!input.equals("D") && !input.equals("U")) {
            throw new IllegalArgumentException("[ERROR] D와 U만 입력 가능합니다.");
        }
    }
    private void addInputList(String alphabet) {
        inputList.add(alphabet);
    }

    public List<String> getInputList() {
        return inputList;
    }

    public void initializeInputList() {
        inputList = new ArrayList<>();
    }

    public boolean compareBridgeBlock(int idx) {
        return inputList.get(idx).equals(answerBridge.get(idx));
    }

    public void exitGame(boolean success, int tryCnt) {
        outputView.printResult(success, this, tryCnt);

    }
    public boolean regame() {
        String input = inputView.readGameCommand();
        if(input.equals("Q") ) {
            return false;
        }
        if(input.equals("R")) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] Q와 R만 입력하실 수 있습니다.");
    }

}
