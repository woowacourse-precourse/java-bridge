package bridge.Controller;

import bridge.Domain.UserAnswer;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.OutputView;

import java.util.List;

public class GameController {
    private BridgeGame bridgeGame = new BridgeGame();
    private InputController inputController = new InputController();
    private OutputView outputView = new OutputView();

    private Bridge bridge;
    private UserAnswer userAnswer;
    private BridgeMaker bridgeMaker;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private int totalCount;
    private boolean restartChecker;

    public GameController() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        set();
        run(bridge.getBridge());
    }

    private void set() {
        totalCount = 1;
        restartChecker = true;
        outputView.printStartMessage();
        outputView.printRequestLengthOfBridgeMessage();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(inputController.setBridgeSize()));
        userAnswer = new UserAnswer();
    }

    private void run(List<String> bridge) {
        do {
            getUserInput();
            outputView.printMap(bridge, userAnswer.getAnswer());
            if (!bridgeGame.move(bridge, userAnswer.getAnswer(), userAnswer.getSize() - 1)) {
                restartCheck();
            }
        } while (restartChecker && bridge.size() != userAnswer.getSize());
        outputView.printResult(bridge, userAnswer.getAnswer(), totalCount);
    }

    private void getUserInput() {
        outputView.printRequestMoveAreaMessage();
        String nextMove = inputController.setMove();
        userAnswer.addAnswer(nextMove);
    }

    private void restartCheck() {
        outputView.printAskRestartGameMessage();
        restartChecker = bridgeGame.retry(inputController.setRestart());
        if (restartChecker) {
            totalCount++;
            userAnswer = new UserAnswer();
        }
    }
}
