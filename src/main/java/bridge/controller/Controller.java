package bridge.controller;

import bridge.BridgeGame;
import bridge.DownsideResults;
import bridge.OneSideResults;
import bridge.UpsideResults;
import bridge.util.CommandKeys;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private static final int INITIAL_COUNT = 1;
    private final static String BLANK_SPACE = " ";
    private final static String SUCCESS = "성공";
    private final static String FAILURE = "실패";

    private final int bridgeSize;
    private final BridgeGame bridgeGame;

    public Controller() {
        OutputView.printGameStart();
        bridgeSize = InputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public void play() {
        int totalTrialCount = INITIAL_COUNT;
        String finalResult = SUCCESS;
        int index = 0;

        OneSideResults upsideResults = null;
        OneSideResults downsideResults = null;
        while (index < bridgeSize) {
            upsideResults = new UpsideResults();
            downsideResults = new DownsideResults();

            final String playerMove = InputView.readMoving();
            final String matchResult = bridgeGame.move(playerMove, index);

            upsideResults.update(playerMove, matchResult, BLANK_SPACE);
            downsideResults.update(playerMove, matchResult, BLANK_SPACE);

            OutputView.printMap(upsideResults, downsideResults);
            index++;

            if (matchResult.equals("X")) {
                final String playerCommand = InputView.readGameCommand();
                if (CommandKeys.isRetry(playerCommand)) {
                    index = 0;
                    upsideResults.reset(playerCommand);
                    downsideResults.reset(playerCommand);
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
}
