package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    List<String> bridge = new ArrayList<>();
    static List<String> isCorrectList = new ArrayList<>();
    int turn = 0;
    boolean isWin = false;
    public void start() {
        int lengthOfBridge = gameStart();
        selectMoving(lengthOfBridge);
        printResultOfGame(isWin);
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

    public void selectMoving(int lengthOfBridge) {
        while (!isWin) {
            String userMove = InputView.readMoving();
            outputView.setUpAndDownSide(userMove, bridge.get(turn));
            boolean isCorrect = bridgeGame.move(bridge, userMove);
            outputView.printMap();
            turn ++;
            if (!isCorrect) selectQuitOrRestart(lengthOfBridge);
            if (isSuccess(isCorrect, lengthOfBridge)) isWin = true;
        }
    }

    public void selectQuitOrRestart(int lengthOfBridge) {
        String restartOrQuit = InputView.readGameCommand();
        if (restartOrQuit.equals("R")) restartGame(lengthOfBridge);
        if (restartOrQuit.equals("Q")) isWin = false;
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
