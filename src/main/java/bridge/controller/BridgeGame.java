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
        startGame();
        boolean flag = true;
        while (isRepeat(flag, user)) {
            move();
            if (!answerBridge.isCorrect(user)) {
                flag = retry();
            }
            checkApproachEnd(answerBridge, user);
        }
        OutputView.printResult(user, answerBridge.compareTo(user));
    }

    private void startGame() {
        OutputView.printStart();
        makeAnswerBridge();
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

    private boolean isRepeat(boolean flag, User user) {
        return (flag && !user.getDoesSuccess());
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

    private void checkApproachEnd(AnswerBridge answerBridge, User user) {
        if (answerBridge.isApproachEnd(user.getChoices())) {
            user.doSuccess();
        }
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
            user.resetChoices();
            return true;
        }
        return false;
    }

}
