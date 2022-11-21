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
    private static final String BLANK_SPACE = " ";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";

    private final List<String> answerBridge;
    private final BridgeGame bridgeGame;

    private int totalTrialCount;
    private String finalResult;

    public Controller() {
        OutputView.printGameStart();
        answerBridge = createAnswerBridge(InputView.readBridgeSize());
        bridgeGame = new BridgeGame();
        totalTrialCount = INITIAL_COUNT;
        finalResult = SUCCESS;
    }

    private List<String> createAnswerBridge(int bridgeSize) {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(answerBridge); // 추후 삭제
        return answerBridge;
    }

    public void play() {
        final OneSideResults upsideResults = new UpsideResults();
        final OneSideResults downsideResults = new DownsideResults();

        for (int index = 0; index < answerBridge.size(); index++) {
            final String playerMove = InputView.readMoving();
            final String answerMove = answerBridge.get(index);
            final String matchResult = bridgeGame.move(playerMove, answerMove);
            upsideResults.update(playerMove, matchResult);
            downsideResults.update(playerMove, matchResult);
            OutputView.printMap(upsideResults, downsideResults);

            if (matchResult.equals("X")) {
                final String playerCommand = InputView.readGameCommand();
                if (CommandKeys.isRetry(playerCommand)) {
                    index = -1;
                    resetResults(upsideResults, downsideResults, playerCommand);
                    totalTrialCount = bridgeGame.retry(totalTrialCount);
                }
                if (CommandKeys.isQuit(playerCommand)) {
                    finalResult = FAILURE;
                    break;
                }
            }
        }
        OutputView.printResult(upsideResults, downsideResults, finalResult);
        OutputView.printTotalTrialCount(totalTrialCount);
    }

    private void resetResults(
            OneSideResults oneSideResults,
            OneSideResults theOtherSideResults,
            String playerCommand
    ) {
        oneSideResults.reset(playerCommand);
        theOtherSideResults.reset(playerCommand);
    }
}
