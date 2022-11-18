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
        makeAnswerBridge();

        boolean flag = true;
        while (flag) {
            move();

            if (!checkCorrect(answerBridge, user)) {
                flag = retry();
            }

            if (flag && checkApproachEnd(answerBridge, user)) {
                break;
            }
        }

        OutputView.printResult(user, answerBridge.compareTo(user));
    }

    private boolean checkApproachEnd(AnswerBridge answerBridge, User user) {
        if (answerBridge.isApproachEnd(user.getChoices())) {
            user.doSuccess();
            return true;
        }
        return false;
    }

    private boolean checkCorrect(AnswerBridge answerBridge, User user) {
        if (answerBridge.isCorrect(user)) {
            return true;
        }
        return false;
    }

    public boolean retry() {
        String retryCommand;
        while (true) {
            try {
                retryCommand = InputView.getInputRetryCommand();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
        return isRetry(retryCommand);
    }

    private boolean isRetry(String retryCommand) {
        if (retryCommand.equals("R")) {
            resetGame();
            return true;
        }
        return false;
    }

    private void makeAnswerBridge() {
        while (true) {
            try {
                int bridgeSize = InputView.getInputBridgeSize();
                List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
                answerBridge = new AnswerBridge(bridge);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
    }

    public void move() {
        while (true) {
            try {
                String choice = InputView.getInputChoice();
                user.addChoice(choice);
                OutputView.printMap(user.getChoices(), answerBridge.compareTo(user));
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
    }

    private void resetGame() {
        user.resetChoices();
    }
}
