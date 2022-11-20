package game;

import bridge.BridgeDraw;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import game.BridgeGame;
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

    public void restartOrNot() {
        if (inputView.readGameCommand().equals("R")) {
            countRestart++;
            repeatMakeResult();
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

    public void sameWithAnswer(String userInput, int index) {
        bridgeGame.isValueSame(userInput, upAndDown);
        outputView.printMap(upAndDown);
        isValueSpecial(index);
    }

    public void diffWithAnswer(String userInput) {
        bridgeGame.isValueDiff(userInput, upAndDown);
        outputView.printMap(upAndDown);
        upAndDown = new ArrayList<>(Arrays.asList("", ""));
        restartOrNot();
    }

    public String makeResult(String answerInput, int index) {
        String userInput = inputView.readMoving();
        if (userInput.equals(answerInput)) {
            sameWithAnswer(userInput, index);
        }
        if (!userInput.equals(answerInput)) {
            diffWithAnswer(userInput);
        }
        return userInput;
    }

    public void repeatMakeResult() {
        int i = 0;
        while (i < answerBridge.size()) {
            String userInput = makeResult(answerBridge.get(i), i);
            if (!userInput.equals(answerBridge.get(i))) {
                break;
            }
            i++;
        }
    }

    public void startGame() {
        int size = inputView.readBridgeSize();
        answerBridge = bridgeMaker.makeBridge(size);
        repeatMakeResult();
    }
}
