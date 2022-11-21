package bridge.controller;

import bridge.model.AnswerBridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.User;
import bridge.model.constant.Message;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGame {

    AnswerBridge answerBridge;
    User user = new User();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    boolean flag = true;

    public void run() {
        startGame();
        while (doesRepeat(flag, user)) {
            move();
            if (!isCorrectChoice()) {
                flag = retry();
            }
            isApproachEndPoint();
        }
        finishGame();
    }

    private void startGame() {
        OutputView.printStart();
        buildAnswerBridge();
    }

    private void buildAnswerBridge() {
        while (true) {
            try {
                int bridgeSize = InputView.readBridgeSize();
                List<String> madeBridge = bridgeMaker.buildBridge(bridgeSize);
                answerBridge = new AnswerBridge(madeBridge);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
    }

    private boolean doesRepeat(final boolean flag, final User user) {
        return (flag && !user.getIsSuccess());
    }

    public void move() {
        while (true) {
            try {
                String choice = InputView.readChoice();
                user.addChoice(choice);
                OutputView.printMap(user.getChoices(), answerBridge.compareTo(user.getChoices()));
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
    }

    private boolean isCorrectChoice() {
        return answerBridge.isCorrectChoice(user.getStep(), user.getLastChoice());
    }

    public boolean retry() {
        String retryCommand;
        while (true) {
            try {
                retryCommand = InputView.readRetryCommand();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
        return isRetry(retryCommand);
    }

    private boolean isRetry(final String retryCommand) {
        if (retryCommand.equals(Message.RE_START)) {
            user.resetChoices();
            user.addTryCount();
            return true;
        }
        return false;
    }

    private void isApproachEndPoint() {
        if (answerBridge.isApproachEndPoint(user.getChoices())) {
            user.doSuccess();
        }
    }

    private void finishGame() {
        OutputView.printResult(user, answerBridge.compareTo(user.getChoices()));
    }
}