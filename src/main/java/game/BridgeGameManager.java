package game;

import bridge.BridgeDraw;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import view.InputView;
import view.OutputView;
import view.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGameManager {
    private static List<String> answerBridge = new ArrayList<>();

    private List<String> upAndDown = new ArrayList<>(Arrays.asList("", ""));

    private int countRestart = 1;

    private static final InputView inputView = new InputView();

    private static final OutputView outputView = new OutputView();

    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    private static final BridgeGame bridgeGame = new BridgeGame();

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

    public void isValueSpecial(int size, int index) {
        if ((index >= 0 && upAndDown.get(0).contains(" ")) && index < size-1) {
            upAndDown.set(0, upAndDown.get(0) + BridgeDraw.line.getDraw());
            upAndDown.set(1, upAndDown.get(1) + BridgeDraw.line.getDraw());
        }
        if (index == size-1) {
            outputView.printSuccessResult(countRestart, upAndDown);
        }
    }

    public void isValueSame(String userInput, int size, int index) {
        bridgeGame.isValueSame(userInput, upAndDown);
        outputView.printMap(upAndDown);
        isValueSpecial(size, index);
    }

    public void isValueDiff(String userInput, int size) {
        bridgeGame.isValueDiff(userInput, upAndDown);
        outputView.printMap(upAndDown);
        upAndDown = new ArrayList<>(Arrays.asList("", ""));
        restartOrNot(size);
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

    public void startGame() {
        int size = returnSize();
        generateAnswer(size);
        repeatBridge(size);
    }
}
