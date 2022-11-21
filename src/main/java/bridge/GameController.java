package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.Stack;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    GameController() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = ready();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        run();
    }

    private int ready() {
        outputView.printStart();
        return inputView.readBridgeSize();
    }

    private void run() {
        play();
    }

    private void play() {
        boolean moveResult = true;
        outputView.printPlay();
        String movingValue = inputView.readMoving();
        moveResult = bridgeGame.isCorrect(movingValue);
        List<Stack> stairs = bridgeGame.move(movingValue, moveResult);
        outputView.printStairs(stairs);
        if(moveResult && !bridgeGame.isFinishWithAllCollect()) {
           play();
        }
    }
}
