package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.Domain.BridgeNumberGenerator;
import bridge.Domain.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    List<String> bridge = new ArrayList<>();
    List<String> isCorrectList = new ArrayList<>();
    int turn = 0;
    public void start() {
        int lengthOfBridge = gameStart();
        boolean isCorrect = selectMoving(lengthOfBridge);
        printResultOfGame(isCorrect);
    }

    public int gameStart() {
        outputView.printGameStart();
        outputView.printEmptyLine();
        int lengthOfBridge = InputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(lengthOfBridge);
        outputView.printEmptyLine();
        return lengthOfBridge;
    }

    public boolean selectMoving(int lengthOfBridge) {
        while (true) {
            String userMove = InputView.readMoving();
            outputView.setUpAndDownSide(userMove, bridge.get(turn));
            boolean isCorrect = bridgeGame.move(bridge, userMove);
            outputView.printMap();
            turn ++;
            if (!isCorrect) return selectQuitOrRestart(lengthOfBridge);
            if (isSuccess(isCorrect, lengthOfBridge)) return true;
        }
    }

    public boolean selectQuitOrRestart(int lengthOfBridge) {
        String restartOrQuit = InputView.readGameCommand();
        if (restartOrQuit.equals("R")) restartGame(lengthOfBridge);
        if (restartOrQuit.equals("Q")) return false;
        return false;
    }

    public void restartGame(int lengthOfBridge) {
        bridgeGame.retry();
        turn = 0;
        OutputView.upSide.clear();
        OutputView.downSide.clear();
        isCorrectList.clear();
        selectMoving(lengthOfBridge);
    }

    public boolean isSuccess(boolean isCorrect, int lengthOfBridge) {
        if (isCorrect) isCorrectList.add("O");
        if (isCorrectList.size() == lengthOfBridge) return true;
        return false;
    }

    public void printResultOfGame(boolean isCorrect) {
        int tryAmount = bridgeGame.getAttemp();
        outputView.printResult(tryAmount, isCorrect);
    }
}
