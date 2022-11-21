package bridge;

import bridge.controller.BridgeGame;
import bridge.model.AnswerBridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.User;
import bridge.model.constant.Message;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {

    private AnswerBridge answerBridge;
    private BridgeGame bridgeGame = new BridgeGame();
    private User user = new User();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    boolean playing = true;

    public void run() {
        startGame();

        while(doesRepeat()) {
            move();
            checkCorrectChoice();
            checkApproachEndPoint();
        }

        finishGame();
    }

    private void startGame() {
        OutputView.printStart();
        makeAnswerBridge();
    }

    private void makeAnswerBridge() {
        int bridgeSize = InputView.readBridgeSize();
        List<String> madeBridge = bridgeMaker.makeBridge(bridgeSize);
        answerBridge = new AnswerBridge(madeBridge);
    }

    private boolean doesRepeat() {
        return (playing && !user.getIsSuccess());
    }

    private void move() {
        String choice = InputView.readChoice();
        bridgeGame.move(user, choice);
        OutputView.printMap(user.getChoices(), answerBridge.compareTo(user.getChoices()));
    }

    private void checkCorrectChoice() {
        if (!isCorrectChoice()) {
            String retryCommand = InputView.readRetryCommand();
            if (retryCommand.equals(Message.RE_START)) {
                bridgeGame.retry(user);
                return;
            }

            playing = false;
        }
    }

    private boolean isCorrectChoice() {
        return answerBridge.isCorrectChoice(user.getStep(), user.getLastChoice());
    }

    private void checkApproachEndPoint() {
        boolean isApproachEndPoint = answerBridge.isApproachEndPoint(user.getChoices());
        if (isApproachEndPoint) {
            user.doSuccess();
        }
    }

    private void finishGame() {
        OutputView.printResult(user, answerBridge.compareTo(user.getChoices()));
    }

    public static void main(String[] args) {
        Application application = new Application();
        try {
            application.run();
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printError(illegalArgumentException);
        }
    }
}
