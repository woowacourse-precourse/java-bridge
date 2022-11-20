package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.view.InputView;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Application {
    private static final int INITIAL_COUNT = 1;
    private final static String BRIDGE_HEAD = "[";
    private final static String BRIDGE_TAIL = "]";
    private final static String BLANK_SPACE = " ";
    private final static String BRIDGE_PARTITION = "|";

    public static void main(String[] args) {
        int trialCount = INITIAL_COUNT;

        final int bridgeSize =  InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(answerBridge);

        final List<String> upSideResult = new ArrayList<>();
        final List<String> downSideResult = new ArrayList<>();
        final BridgeGame bridgeGame = new BridgeGame(answerBridge);

        for (int index = 0; index < answerBridge.size(); index++) {
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
        }
    }
}
