package game;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import view.InputView;
import view.OutputView;
import view.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private List<String> answerBridge = new ArrayList<>();

    private List<String> upAndDown = new ArrayList<>(Arrays.asList("", ""));

    private int countRestart = 1;

    private final InputView inputView = new InputView();

    private final OutputView outputView = new OutputView();

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    private final BridgeGame bridgeGame = new BridgeGame();

    public int returnSize() {
        String size = inputView.readBridgeSize();
        Valid.isLengthValid(size);
        return Integer.parseInt(size);
    }

    public void generateAnswer(int length) {
        answerBridge = bridgeMaker.makeBridge(length);
    }

    public String returnPosition() {
        String pos = inputView.readMoving();
        Valid.isEnterValid(pos);
        return pos;
    }

    public String returnFinish() {
        String fin = inputView.readGameCommand();
        Valid.isEnterFinishValid(fin);
        return fin;
    }

    public void restartOrNot(int size) {
        if (returnFinish().equals("R")) {
            countRestart++;
            repeatBridge(size);
        }
    }

    public void isValueSame(String userInput, int size, int index) {
        bridgeGame.isValueSame(userInput, upAndDown);
        if (index == size-1) {
            outputView.printSuccessResult(countRestart, upAndDown);
        }
        if (index != size-1) {
            outputView.printMap(upAndDown);
        }
    }

    public void isValueDiff(String userInput, int size) {
        bridgeGame.isValueDiff(userInput, upAndDown);
        restartOrNot(size);
        outputView.printResult(countRestart, upAndDown);
    }

    public String makeBridge(String answerInput, int size, int index) {
        String userInput = returnPosition();
        if (userInput.equals(answerInput)) {
            isValueSame(userInput, size, index);
        }
        if (!userInput.equals(answerInput)) {
            isValueDiff(userInput, size);
        }
        return userInput;
    }

    public void repeatBridge(int size) {
        for (int i = 0; i < size; i++) {
            String userInput = makeBridge(answerBridge.get(i), size, i);
            if (!userInput.equals(answerBridge.get(i))) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
    }

}
