package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
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
        final List<String> answerBridge = createAnswerBridge(bridgeSize);
        System.out.println(answerBridge); // 추후 삭제
        this.bridgeGame = new BridgeGame(answerBridge);
    }

    public List<String> createAnswerBridge(int bridgeSize) {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void play() {
        int trialCount = INITIAL_COUNT;
        String gameResult = SUCCESS;
        List<String> upSideResults = new ArrayList<>();
        List<String> downSideResults = new ArrayList<>();
        int index = 0;

        while (index < bridgeSize) {
            final String currentMoving = InputView.readMoving();
            final String moveResult = bridgeGame.move(currentMoving, index);

            if (bridgeGame.isMovingUp(currentMoving)) {
                bridgeGame.updateOneSideResults(upSideResults, moveResult);
                bridgeGame.updateOneSideResults(downSideResults, BLANK_SPACE);
            }

            if (bridgeGame.isMovingDown(currentMoving)) {
                bridgeGame.updateOneSideResults(upSideResults, BLANK_SPACE);
                bridgeGame.updateOneSideResults(downSideResults, moveResult);
            }

            OutputView.printMap(index, upSideResults, downSideResults);
            index++;

            if (moveResult.equals("X")) {
                final String playerCommand = InputView.readGameCommand();
                if (playerCommand.equals("R")) {
                    index = 0;
                    upSideResults = new ArrayList<>();
                    downSideResults = new ArrayList<>();
                    trialCount = bridgeGame.retry(trialCount);
                }
                if (playerCommand.equals("Q")) {
                    gameResult = FAILURE;
                    break;
                }
            }
        }
        if (gameResult.equals(SUCCESS)) {
            OutputView.printResult(index - 1, upSideResults, downSideResults, gameResult);
            OutputView.printTotalTrialCount(trialCount);
        }
        if (gameResult.equals(FAILURE)) {
            OutputView.printResult(index - 1, upSideResults, downSideResults, gameResult);
            OutputView.printTotalTrialCount(trialCount);
        }
    }
}
