package bridge.model;

import bridge.BridgeMaker;
import bridge.model.ScreenGenerator.ScreenGenerator;
import java.util.List;

public class BridgeAnswer {

    private static Integer currentSpot = 0;
    private static final int REACHED_END = 1;
    private static final int COMPARE_SAME = 2;
    private static final int COMPARE_DIFFERENT = 3;
    private static final int ZERO = 0;

    private final List<String> answer;

    private BridgeAnswer(final List<String> answerBridge) {
        this.answer = answerBridge;
    }

    public static BridgeAnswer using(final BridgeMaker bridgeMaker, final BridgeLength bridgeLength) {
        return new BridgeAnswer(bridgeMaker.makeBridge(bridgeLength.getLength()));
    }

    public ScreenGenerator printCurrentBridgeStatus(final int printCase) {
        BridgeScreenModeSelector bridgeScreenGenerator = new BridgeScreenModeSelector(answer, currentSpot, printCase);
        return bridgeScreenGenerator.generateOutputScreen();
    }

    public int compareWithUserMove(final int place, final String userInput) {
        currentSpot = place;
        if (place == answer.size() - 1 && answer.get(place).equals(userInput)) {
            return REACHED_END;
        } else if (answer.get(place).equals(userInput)) {
            return COMPARE_SAME;
        }
        return COMPARE_DIFFERENT;
    }

    public void resetCurrentSpot() {
        currentSpot = ZERO;
    }
}
