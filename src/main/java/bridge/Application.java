package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int INITIAL_COUNT = 1;
    private final static String BRIDGE_HEAD = "[";
    private final static String BRIDGE_TAIL = "]";
    private final static String BLANK_SPACE = " ";
    private final static String BRIDGE_PARTITION = "|";
    private final static String SUCCESS = "성공";
    private final static String FAILURE = "실패";


    public static void main(String[] args) {
        int trialCount = INITIAL_COUNT;
        String gameResult = SUCCESS;

        final int bridgeSize =  InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(answerBridge);

        List<String> upSideResult = new ArrayList<>();
        List<String> downSideResult = new ArrayList<>();
        final BridgeGame bridgeGame = new BridgeGame(answerBridge);

        int index = 0;
        while (index < answerBridge.size()) {
            final String playerMoving = InputView.readMoving();
            final String result = bridgeGame.move(answerBridge.get(index), playerMoving);

            if (playerMoving.equals("U")) {
                upSideResult.add(result);
                downSideResult.add(BLANK_SPACE);
            }

            if (playerMoving.equals("D")) {
                upSideResult.add(BLANK_SPACE);
                downSideResult.add(result);
            }

            OutputView.printMap(index, upSideResult, downSideResult);
            index++;

            if (result.equals("X")) {
                final String playerCommand = InputView.readGameCommand();
                if (playerCommand.equals("R")) {
                    index = 0;
                    upSideResult = new ArrayList<>();
                    downSideResult = new ArrayList<>();
                    bridgeGame.retry();
                }
                if (playerCommand.equals("Q")) {
                    gameResult = FAILURE;
                    break;
                }
            }
        }
        if (gameResult.equals(SUCCESS)) {
            OutputView.printResult(index - 1, upSideResult, downSideResult, gameResult);
            OutputView.printTotalTrialCount(bridgeGame.trialCount);
        }
        if (gameResult.equals(FAILURE)) {
            OutputView.printResult(index - 1, upSideResult, downSideResult, gameResult);
            OutputView.printTotalTrialCount(bridgeGame.trialCount);
        }
    }
}
