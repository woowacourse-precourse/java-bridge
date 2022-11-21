package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.util.CommandKeys;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int INITIAL_COUNT = 1;
    private final static String BLANK_SPACE = " ";
    private final static String SUCCESS = "성공";
    private final static String FAILURE = "실패";

    public static void main(String[] args) {
        OutputView.printGameStart();
        int trialCount = INITIAL_COUNT;
        String gameResult = SUCCESS;

        final int bridgeSize =  InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(answerBridge);

        List<String> upSideResults = new ArrayList<>();
        List<String> downSideResults = new ArrayList<>();
        final BridgeGame bridgeGame = new BridgeGame(answerBridge);

        int index = 0;
        while (index < answerBridge.size()) {
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
}
