package bridge.utils.output;

import bridge.utils.constants.BridgeConstants;
import bridge.utils.constants.Result;
import java.util.List;

public class BridgeStatus {

    private StringBuilder upBridgeBuilder;
    private StringBuilder downBridgeBuilder;

    public void init(List<Result> results) {
        upBridgeBuilder = new StringBuilder();
        downBridgeBuilder = new StringBuilder();

        appendPoint(BridgeConstants.BRIDGE_START_POINT);
        appendResult(results);
        appendPoint(BridgeConstants.BRIDGE_END_POINT);
    }

    private void appendResult(List<Result> results) {
        for (int loc = 0; loc < results.size(); loc++) {
            if (loc > 0) {
                appendPoint(BridgeConstants.BRIDGE_DIVIDING_POINT);
            }
            Result result = results.get(loc);
            appendCorrect(result);
            appendIncorrect(result);
        }
    }

    @Override
    public String toString() {
        return upBridgeBuilder + "\n" + downBridgeBuilder;
    }

    private void appendPoint(String bridgeStartPoint) {
        upBridgeBuilder.append(bridgeStartPoint);
        downBridgeBuilder.append(bridgeStartPoint);
    }

    private void appendCorrect(Result result) {
        if (result.isCorrect()) {
            appendResult(result.getStep(), BridgeConstants.CORRECT_ANSWER);
        }
    }

    private void appendIncorrect(Result result) {
        if (!result.isCorrect()) {
            appendResult(result.getStep(), BridgeConstants.INCORRECT_ANSWER);
        }
    }


    private void appendResult(String step, String correctAnswer) {
        if (step.equals(BridgeConstants.UP_CROSS)) {
            upBridgeBuilder.append(correctAnswer);
            downBridgeBuilder.append(BridgeConstants.SPACE);
        }
        if (step.equals(BridgeConstants.DOWN_CROSS)) {
            upBridgeBuilder.append(BridgeConstants.SPACE);
            downBridgeBuilder.append(correctAnswer);
        }
    }

}
