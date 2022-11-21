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
    private final static String BLANK_SPACE = " ";
    private final static String SUCCESS = "성공";
    private final static String FAILURE = "실패";

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
        System.out.println(answerBridge); // 추후 삭제
        return answerBridge;
    }

    public void play() {
        int totalTrialCount = INITIAL_COUNT;
        String finalResult = SUCCESS;
        int index = 0;

        final OneSideResults upsideResults = new UpsideResults();
        final OneSideResults downsideResults = new DownsideResults();

        while (index < answerBridge.size()) {
            final String playerMove = InputView.readMoving();
            final String matchResult = bridgeGame.move(playerMove, answerBridge.get(index));

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
