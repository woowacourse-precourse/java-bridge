package bridge.Controller;

import bridge.Model.Bridge;
import bridge.Model.GameResult;
import bridge.Service.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameController {

    private static final String RETRY = GameResult.RETRY.getResult();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private int progress;
    private int totalTries = 1;
    private boolean isCleared;

    public void run(Bridge bridge) {
        String lastCommand;

        do {
            lastCommand = repeatGame(bridge);
        } while (lastCommand.equals(RETRY));

        printFinalResult();
    }

    private String repeatGame(Bridge bridge) {
        String command = "";

        isCleared = playOnce(bridge);
        if (!isCleared) {
            command = handleRetryCommand();
            totalTries = bridgeGame.retry(totalTries);
        }

        return command;
    }

    private boolean playOnce(Bridge bridge) {
        final int bridgeSize = bridge.getSize();
        boolean isCrossable = true;
        progress = 0;

        while (isCrossable && bridgeSize > progress) {
            isCrossable = proceed(bridge);
        }

        return isCrossable;
    }

    private boolean proceed(Bridge bridge) {
        String input = handleInput();
        String currentResult = bridge.getResult(input, progress);
        boolean isCrossable = bridgeGame.isCrossable(currentResult);

        progress = bridgeGame.move(progress);
        printResult(currentResult, input);

        return isCrossable;
    }

    private String handleInput() {
        String input = inputView.readMoving();

        return input;
    }

    private String handleRetryCommand() {
        String input = inputView.readGameCommand();

        return input;
    }

    private void printResult(String currentResult, String input) {
        outputView.printMap(currentResult, input, progress);
    }

    private void printFinalResult() {
        outputView.printResult(isCleared, totalTries);
    }
}
