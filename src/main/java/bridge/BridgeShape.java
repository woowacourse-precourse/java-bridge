package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.InputMatcher.DOWNSIDE_OF_BRIDGE;
import static bridge.InputMatcher.UPSIDE_OF_BRIDGE;

public class BridgeShape {

    private final String CORRECT_SIGN = "O";
    private final String WRONG_SIGN = "X";
    private final String NOT_CHOOSING_SIGH = " ";
    private final int BRIDGE_VERTICAL_SIZE = 2;


    private final List<List<String>> bridgeShape = new ArrayList<>();

    public BridgeShape() {
        for (int idx = 0; idx < BRIDGE_VERTICAL_SIZE; idx++) {
            bridgeShape.add(new ArrayList<>());
        }
    }

    public boolean caseWhenUserInputIsUpSide(List<String> answer, int idx) {
        if (UPSIDE_OF_BRIDGE.isCorrect(answer.get(idx))) {
            bridgeShape.get(0).add(CORRECT_SIGN);
            bridgeShape.get(1).add(NOT_CHOOSING_SIGH);
        }
        if (DOWNSIDE_OF_BRIDGE.isCorrect(answer.get(idx))) {
            bridgeShape.get(0).add(WRONG_SIGN);
            bridgeShape.get(1).add(NOT_CHOOSING_SIGH);
            return false;
        }
        return true;
    }

    public boolean caseWhenUserInputIsDownSide(List<String> answer, int idx) {
        if (UPSIDE_OF_BRIDGE.isCorrect(answer.get(idx))) {
            bridgeShape.get(0).add(NOT_CHOOSING_SIGH);
            bridgeShape.get(1).add(WRONG_SIGN);
            return false;
        }
        if (DOWNSIDE_OF_BRIDGE.isCorrect(answer.get(idx))) {
            bridgeShape.get(0).add(NOT_CHOOSING_SIGH);
            bridgeShape.get(1).add(CORRECT_SIGN);
        }
        return true;
    }

    public void retry() {
        bridgeShape.get(0).clear();
        bridgeShape.get(1).clear();
    }

    public List<String> getBridgeUpperSide() {
        return new ArrayList<>(bridgeShape.get(0));
    }

    public List<String> getBridgeDownSide() {
        return new ArrayList<>(bridgeShape.get(1));
    }
}
