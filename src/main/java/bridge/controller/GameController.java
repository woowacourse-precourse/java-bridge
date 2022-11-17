package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.MapShape;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private static final String FAIL_SIGN = "X";
    private static final String RESET_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    private static boolean keepGoing = true;
    private static int currentPosition = 0;
    private static int tryCount = 1;

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

    public void run() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while(keepGoing && currentPosition < bridgeSize){
            String nextMove = inputView.readMoving();
            String moveResult = bridgeGame.move(bridge.get(currentPosition), nextMove);
            outputView.printMap(nextMove, moveResult);
            currentPosition++;
            if(moveResult.matches(FAIL_SIGN)) bridgeGame.retry();
        }
        outputView.printResult(tryCount, keepGoing);
    }

    public static void checkKeepGoing(String resetCommand) {
        if(resetCommand.matches(RESET_COMMAND)) resetGame();
        if(resetCommand.matches(QUIT_COMMAND)) quitGame();
    }

    private static void resetGame() {
        currentPosition = 0;
        tryCount++;
        mapShape.clearMap();
    }

    private static void quitGame() {
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
