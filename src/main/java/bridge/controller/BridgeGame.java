package bridge.controller;

import bridge.model.AnswerBridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.User;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGame {

    AnswerBridge answerBridge;
    User user = new User();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        OutputView.printStart();
        boolean flag = true;
        while (flag) {
            flag = makeAnswerBridge();
        }

        flag = true;
        while (flag) {
            flag = move();

            if (!answerBridge.isCorrect(user)) {
                flag = retry();

                if (flag) {
                    resetGame();
                    continue;
                }
                break;
            }

            if (answerBridge.isApproachEnd(user.getChoices())) {
                user.doSuccess();
                break;
            }
        }

        OutputView.printResult(user, answerBridge.compareTo(user));
    }

    private boolean makeAnswerBridge() {
        try {
            int bridgeSize = InputView.getInputBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            answerBridge = new AnswerBridge(bridge);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printError(illegalArgumentException);
            return true;
        }
        return false;
    }

    public boolean move() {
        try {
            String choice = InputView.getInputChoice();
            user.addChoice(choice);
            OutputView.printMap(user.getChoices(), answerBridge.compareTo(user));
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printError(illegalArgumentException);
            return true;
        }
        return false;
    }

    public boolean retry() {
        try {
            String retryCommand = InputView.getInputRetryCommand();
            if (retryCommand.equals("R")) {
                return true;
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printError(illegalArgumentException);
            return true;
        }
        return false;
    }

    private void resetGame() {
        user.resetChoices();
    }
}
