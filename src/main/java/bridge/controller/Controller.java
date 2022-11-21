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
import java.util.ArrayList;
import java.util.List;

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
        int trialCount = INITIAL_COUNT;
        String gameResult = SUCCESS;
        int index = 0;

        while (index < bridgeSize) {
            final OneSideResults upsideResults = new UpsideResults();
            final OneSideResults downsideResults = new DownsideResults();

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
                    trialCount = bridgeGame.retry(trialCount);
                }
                if (CommandKeys.isQuit(playerCommand)) {
                    gameResult = FAILURE;
                    break;
                }
            }
        }
        if (gameResult.equals(SUCCESS)) {
            OutputView.printResult(upsideResults, downsideResults, gameResult);
            OutputView.printTotalTrialCount(trialCount);
        }
        if (gameResult.equals(FAILURE)) {
            OutputView.printResult(upsideResults, downsideResults, gameResult);
            OutputView.printTotalTrialCount(trialCount);
        }
    }
}
