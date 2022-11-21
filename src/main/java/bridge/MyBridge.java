package bridge;

import java.util.ArrayList;
import java.util.List;

public class MyBridge {

    private List<String> inputList;
    private List<String> answerBridge;
    private int size;
    private int tryCnt;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    MyBridge(List<String> answerBridge, int size) {
        this.inputList = new ArrayList<>();
        this.answerBridge = answerBridge;
        this.size = size;
        this.tryCnt = 0;
    }

    public void addTryCnt() {
        tryCnt++;
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
        return inputList.size() == size;
    }

    public void inputAlphabet() {
        String input = inputView.readMoving();
        addInputList(input);
    }

    private void addInputList(String alphabet) {
        inputList.add(alphabet);
    }

    public List<String> getInputList() {
        return inputList;
    }

    public List<String> getAnswerBridge() {
        return answerBridge;
    }

    public void initializeInputList() {
        inputList = new ArrayList<>();
    }

    public boolean compareBridgeBlock(int idx) {
        return inputList.get(idx).equals(answerBridge.get(idx));
    }

    public void exitGame(boolean success) {
        outputView.printResult(success, tryCnt);
    }
}
