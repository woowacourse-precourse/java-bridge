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
    private List<Stack> stairs;
    private int runCnt;

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

    private boolean run() {
        runCnt++;
        boolean isRerun = false;
        boolean pass = play();
        if (!pass) {
            isRerun = Rerun();
        }
        if (!isRerun) {
            return finish(pass);
        }
        return run();
    }

    private boolean Rerun() {
        outputView.printRetry();
        String tryCommand = inputView.readGameCommand();
        return bridgeGame.retry(tryCommand);
    }

    private boolean finish(boolean isSuccess) {
        outputView.printResult(stairs, runCnt, isSuccess);
        return true;
    }

    private boolean play() {
        outputView.printPlay();
        String movingValue = inputView.readMoving();
        boolean moveResult = bridgeGame.isCorrect(movingValue);
        stairs = bridgeGame.move(movingValue, moveResult);
        outputView.printMap(stairs);
        if (bridgeGame.isFinishWithAllCollect() || !moveResult) {
            return moveResult;
        }
        return play();
    }
}
