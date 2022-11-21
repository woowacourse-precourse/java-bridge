package bridge.controller;

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
    private static final int INITIAL_COUNT = 1;
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";

    private final List<String> answerBridge;
    private final BridgeGame bridgeGame;

    private final OneSideResults upsideResults;
    private final OneSideResults downsideResults;

    private int totalTrialCount;
    private String finalResult;

    public Controller() {
        OutputView.printGameStart();
        answerBridge = createAnswerBridge(InputView.readBridgeSize());
        bridgeGame = new BridgeGame();
        totalTrialCount = INITIAL_COUNT;
        finalResult = SUCCESS;
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

            if (matchResult.equals("X")) {
                index = setIndex(index);
            }
        }
        OutputView.printResult(upsideResults, downsideResults, finalResult);
        OutputView.printTotalTrialCount(totalTrialCount);
    }

    private void updateResults(String playerMove, String matchResult) {
        upsideResults.update(playerMove, matchResult);
        downsideResults.update(playerMove, matchResult);
    }

    private int setIndex(int index) {
        final String playerCommand = InputView.readGameCommand();
        if (CommandKeys.isRetry(playerCommand)) {
            index = -1;
            resetResults(playerCommand);
            totalTrialCount = bridgeGame.retry(totalTrialCount);
        }
        if (CommandKeys.isQuit(playerCommand)) {
            finalResult = FAILURE;
            index = answerBridge.size() - 1;
        }
        return index;
    }

    private void resetResults(String playerCommand) {
        upsideResults.reset(playerCommand);
        downsideResults.reset(playerCommand);
    }
}
