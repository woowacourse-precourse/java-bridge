package game;

import bridge.BridgeDraw;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import view.InputView;
import view.OutputView;
import view.Valid;
import view.ValidMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGameController {
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

    public void generateAnswer(int size) {
        answerBridge = bridgeMaker.makeBridge(size);
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

    public void restartOrNot() {
        if (returnFinish().equals("R")) {
            countRestart++;
            repeatBridge();
        }
    }

    public void isValueSpecial(int index) {
        if ((index >= 0 && upAndDown.get(0).contains(" ")) && index < answerBridge.size()-1) {
            upAndDown.set(0, upAndDown.get(0) + BridgeDraw.line.getDraw());
            upAndDown.set(1, upAndDown.get(1) + BridgeDraw.line.getDraw());
        }
        if (index == answerBridge.size()-1) {
            outputView.printSuccessResult(countRestart, upAndDown);
        }
    }

    public void isValueSame(String userInput, int index) {
        bridgeGame.isValueSame(userInput, upAndDown);
        outputView.printMap(upAndDown);
        isValueSpecial(index);
    }

    public void isValueDiff(String userInput) {
        bridgeGame.isValueDiff(userInput, upAndDown);
        outputView.printMap(upAndDown);
        upAndDown = new ArrayList<>(Arrays.asList("", ""));
        restartOrNot();
    }

    public String makeBridge(String answerInput, int index) {
        String userInput = returnPosition();
        if (userInput.equals(answerInput)) {
            isValueSame(userInput, index);
        }
        if (!userInput.equals(answerInput)) {
            isValueDiff(userInput);
        }
        return userInput;
    }

    public void repeatBridge() {
        int i = 0;
        while (i < answerBridge.size()) {
            String userInput = makeBridge(answerBridge.get(i), i);
            if (!userInput.equals(answerBridge.get(i))) {
                break;
            }
            i++;
        }
    }

    public void doAfterValid(String message) {
        String exceptionMessage = "java.lang.IllegalArgumentException: ";
        if (message.equals(exceptionMessage+ValidMessage.ValidLength.getMessage())) {
            startGame();
        }
        if (message.equals(exceptionMessage+ValidMessage.ValidMove.getMessage())) {
            doAfterEnterException();
        }
        if (message.equals(exceptionMessage+ValidMessage.ValidFinish.getMessage())) {
            doAfterFinishException();
        }
    }

    public void doAfterEnterException() {
        String errorMessage = "";
        try {
            repeatBridge();
        } catch (IllegalArgumentException message) {
            errorMessage = String.valueOf(message);
            System.out.println(errorMessage);
        } finally {
            doAfterValid(errorMessage);
        }
    }

    public void doAfterFinishException() {
        String errorMessage = "";
        try {
            restartOrNot();
        } catch (IllegalArgumentException message) {
            errorMessage = String.valueOf(message);
            System.out.println(errorMessage);
        } finally {
            doAfterValid(errorMessage);
        }
    }

    public void startGame() {
        String errorMessage = "";
        try {
            generateAnswer(returnSize());
            repeatBridge();
        } catch (IllegalArgumentException message) {
            errorMessage = String.valueOf(message);
            System.out.println(errorMessage);
        } finally {
            doAfterValid(errorMessage);
        }
    }
}
