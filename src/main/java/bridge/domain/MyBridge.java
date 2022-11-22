package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.validate.Validator.validateMove;
import static bridge.validate.Validator.validateRetry;

public class MyBridge {

    private List<String> inputList;
    private List<String> answerBridge;

    public MyBridge(List<String> answerBridge, List<String> inputList) {
        this.inputList = inputList;
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
        String input = InputView.readMoving();
        addInputList(input);
        try{validateMove(input);}
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            popInputList();
            inputAlphabet();
        }
    }
    

    private void addInputList(String alphabet) {
        inputList.add(alphabet);
    }

    private void popInputList() {
        inputList.remove(inputList.size() - 1);
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
        OutputView.printResult(success, this, tryCnt);

    }
    public boolean reGame() {
        String input = InputView.readGameCommand();
        boolean retry = false;
        try{
            retry = validateRetry(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return reGame();
        }
        return retry;
    }



}
