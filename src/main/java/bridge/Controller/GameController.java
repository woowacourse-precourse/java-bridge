package bridge.Controller;

import bridge.Model.Bridge;
import bridge.Model.GameResult;
import bridge.Service.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameController {

    private static final String RETRY = GameResult.RETRY.getResult();
    private int progress;
    private int totalTries = 1;
    private boolean isCleared;
    private BridgeGame bridgeGame = new BridgeGame();

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

        while (isCrossable && bridgeSize > progress) { //TODO: 라인 줄이기
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
        InputView inputView = new InputView();

        String input = inputView.readMoving();

        return input;
    }

    private String handleRetryCommand() {
        InputView inputView = new InputView(); //인스턴스 중복 생성?

        String input = inputView.readGameCommand();

        return input;
    }

    private void printResult(String currentResult, String input) {
        OutputView outputView = new OutputView();

        outputView.printMap(currentResult, input, progress);
    }

    private void printFinalResult() {
        OutputView outputView = new OutputView();

        outputView.printResult(isCleared, totalTries);
    }
}
