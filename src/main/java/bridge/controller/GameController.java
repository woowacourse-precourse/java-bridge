package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.MapShape;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.Constant.*;

public class GameController {

    private static boolean keepGoing = true;
    private static int currentPosition = 0;
    private static int tryCount = 1;
    private static int bridgeSize;

    private static List<String> bridge;

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private static MapShape mapShape;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        mapShape = new MapShape();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void gameStart(){
        inputView.printStartMessage();
        setGame();
        while(keepGoing && currentPosition < bridgeSize){
            playBridgeGame();
        }
        outputView.printResult(tryCount, keepGoing);
    }

    private void setGame() {
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private void playBridgeGame() {
        String nextMove = inputView.readMoving();
        String moveResult = bridgeGame.move(bridge.get(currentPosition), nextMove);
        outputView.printMap(nextMove, moveResult);
        currentPosition++;
        if(moveResult.equals(FAIL_SIGN)) {
            String retryCommand = inputView.readGameCommand();
            bridgeGame.retry(retryCommand);
        }
    }

    public static void resetGame() {
        currentPosition = 0;
        tryCount++;
        mapShape.clearMap();
    }

    public static void quitGame() {
        keepGoing = false;
    }

    public void resetTotalGame(){
        tryCount = 1;
        currentPosition = 0;
        keepGoing = true;
        bridgeMaker.clearBridge();
        mapShape.clearMap();
    }
}
