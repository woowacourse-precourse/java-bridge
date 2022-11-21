package bridge.controller;

import static bridge.util.Constants.*;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.DownsideResults;
import bridge.OneSideResults;
import bridge.UpsideResults;
import bridge.util.CommandKeys;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Controller {
    private final List<String> answerBridge;
    private final BridgeGame bridgeGame;
    private final OneSideResults upsideResults;
    private final OneSideResults downsideResults;

    public Controller() {
        OutputView.printGameStart();
        answerBridge = createAnswerBridge(InputView.readBridgeSize());
        bridgeGame = new BridgeGame();
        upsideResults = new UpsideResults();
        downsideResults = new DownsideResults();
    }

    private List<String> createAnswerBridge(int bridgeSize) {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(answerBridge); // 추후 삭제
        return answerBridge;
    }

    public void play() {
        for (int index = 0; index < answerBridge.size(); index++) {
            final String playerMove = InputView.readMoving();
            final String matchResult = bridgeGame.move(playerMove, answerBridge.get(index));
            updateResults(playerMove, matchResult);
            OutputView.printMap(upsideResults, downsideResults);
            index = setIndexByMatchResult(index, matchResult);
        }
        OutputView.printResult(upsideResults, downsideResults, bridgeGame);
    }

    private void updateResults(String playerMove, String matchResult) {
        upsideResults.update(playerMove, matchResult);
        downsideResults.update(playerMove, matchResult);
    }

    private int setIndexByMatchResult(int index, String matchResult) {
        if (wasWrongMove(matchResult)) {
            final String playerCommand = InputView.readGameCommand();
            checkIfContinueOrNot(playerCommand);
            index = setIndex(index, playerCommand);
        }
        return index;
    }

    private boolean wasWrongMove(String matchResult) {
        return matchResult.equals(WRONG_MOVE);
    }

    private void checkIfContinueOrNot(String playerCommand) {
        if (CommandKeys.isRetry(playerCommand)) {
            resetResults(playerCommand);
            bridgeGame.retry();
        }
        if (CommandKeys.isQuit(playerCommand)) {
            bridgeGame.quit();
        }
    }

    private void resetResults(String playerCommand) {
        upsideResults.reset(playerCommand);
        downsideResults.reset(playerCommand);
    }

    private int setIndex(int index, String playerCommand) {
        if (CommandKeys.isRetry(playerCommand)) {
            index = toFirstIndex();
        }
        if (CommandKeys.isQuit(playerCommand)) {
            index = toLastIndex();
        }
        return index;
    }

    private int toFirstIndex() {
        return -1;
    }

    private int toLastIndex() {
        return answerBridge.size() - 1;
    }
}
