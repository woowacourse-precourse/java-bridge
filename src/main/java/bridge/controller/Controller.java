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

    private String finalResult;

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

            if (wasWrongMove(matchResult)) {
                final String playerCommand = InputView.readGameCommand();
                if (CommandKeys.isRetry(playerCommand)) {
                    index = -1;
                    resetResults(playerCommand);
                    bridgeGame.retry();
                }
                if (CommandKeys.isQuit(playerCommand)) {
                    bridgeGame.quit();
                    index = answerBridge.size() - 1;
                }
            }
        }
        OutputView.printResult(upsideResults, downsideResults, bridgeGame);
    }

    private void updateResults(String playerMove, String matchResult) {
        upsideResults.update(playerMove, matchResult);
        downsideResults.update(playerMove, matchResult);
    }

    private static boolean wasWrongMove(String matchResult) {
        return matchResult.equals(WRONG_MOVE);
    }

    private void resetResults(String playerCommand) {
        upsideResults.reset(playerCommand);
        downsideResults.reset(playerCommand);
    }
}
