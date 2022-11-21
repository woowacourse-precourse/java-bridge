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

    private final List<String> upSideResults;
    private final List<String> downSideResults;
    private final BridgeGame bridgeGame;

    public Controller(BridgeGame bridgeGame) {
        this.upSideResults = new ArrayList<>();
        this.downSideResults = new ArrayList<>();
        this.bridgeGame = bridgeGame;
    }

    public void play() {
        OutputView.printGameStart();
        int trialCount = INITIAL_COUNT;
        String gameResult = SUCCESS;

        final int bridgeSize =  InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(answerBridge);

        final BridgeGame bridgeGame = new BridgeGame(answerBridge);

        int index = 0;
        while (index < answerBridge.size()) {
            final String currentMoving = InputView.readMoving();
            final String moveResult = bridgeGame.move(currentMoving, index);

            if (isMovingUp(currentMoving)) {
                updateOneSideResults(upSideResults, moveResult);
                updateOneSideResults(downSideResults, BLANK_SPACE);
            }

            if (isMovingDown(currentMoving)) {
                updateOneSideResults(upSideResults, BLANK_SPACE);
                updateOneSideResults(downSideResults, moveResult);
            }

            OutputView.printMap(index, upSideResults, downSideResults);
            index++;

            if (moveResult.equals("X")) {
                final String playerCommand = InputView.readGameCommand();
                if (playerCommand.equals("R")) {
                    index = 0;
                    upSideResults = new ArrayList<>();
                    downSideResults = new ArrayList<>();
                    bridgeGame.retry();
                }
                if (playerCommand.equals("Q")) {
                    gameResult = FAILURE;
                    break;
                }
            }
        }
        if (gameResult.equals(SUCCESS)) {
            OutputView.printResult(index - 1, upSideResults, downSideResults, gameResult);
            OutputView.printTotalTrialCount(bridgeGame.trialCount);
        }
        if (gameResult.equals(FAILURE)) {
            OutputView.printResult(index - 1, upSideResults, downSideResults, gameResult);
            OutputView.printTotalTrialCount(bridgeGame.trialCount);
        }
    }

    private static void updateOneSideResults(List<String> oneSideResults, String moveResult) {
        oneSideResults.add(moveResult);
    }

    private static boolean isMovingUp(String currentMoving) {
        return CommandKeys.isSame(CommandKeys.UP, currentMoving);
    }

    private static boolean isMovingDown(String currentMoving) {
        return CommandKeys.isSame(CommandKeys.DOWN, currentMoving);
    }
}
