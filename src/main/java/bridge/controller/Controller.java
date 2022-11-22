package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.CommandKeys;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Controller {
    private static final int INITIAL_INDEX = -1;

    private final List<String> answerBridge;
    private final BridgeGame bridgeGame;

    public Controller() {
        OutputView.printGameStart();
        answerBridge = createAnswerBridge(InputView.readBridgeSize());
        bridgeGame = new BridgeGame();
    }

    private List<String> createAnswerBridge(int bridgeSize) {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(answerBridge); // 추후 삭제🚨
        return answerBridge;
    }

    public void start() {
        for (int index = 0; index < answerBridge.size(); index++) {
            final String playerMove = InputView.readMoving();
            final String matchResult = bridgeGame.move(playerMove, answerBridge.get(index));
            bridgeGame.updateBothSidesResults(playerMove, matchResult);
            OutputView.printMap(bridgeGame);
            index = changeIndexIfResultsHaveWrongMove(index);
        }
        OutputView.printResult(bridgeGame);
    }

    private int changeIndexIfResultsHaveWrongMove(int index) {
        if (bridgeGame.hasWrongMove()) {
            final String playerCommand = InputView.readGameCommand();
            checkIfContinueOrNot(playerCommand);
            index = firstOrLastIndex(index, playerCommand);
        }
        return index;
    }

    private void checkIfContinueOrNot(String playerCommand) {
        if (CommandKeys.isRetry(playerCommand)) {
            bridgeGame.retry();
        }
        if (CommandKeys.isQuit(playerCommand)) {
            bridgeGame.quit();
        }
    }

    private int firstOrLastIndex(int index, String playerCommand) {
        if (CommandKeys.isRetry(playerCommand)) {
            index = toFirstIndex();
        }
        if (CommandKeys.isQuit(playerCommand)) {
            index = toLastIndex();
        }
        return index;
    }

    private int toFirstIndex() {
        return INITIAL_INDEX; // For statement will increase this index to 0.
    }

    private int toLastIndex() {
        return answerBridge.size() - 1;
    }
}
