package bridge.system.util;

import bridge.vo.BridgeStep;
import bridge.vo.StepResult;

import java.util.List;

public class BridgeMessageMaker {

    public static final String BRIDGE_START = "[";
    public static final String SPACE = "   ";
    public static final String CORRECT = " O ";
    public static final String FAIL = " X ";
    public static final String BRIDGE_END = "]";

    public String makeBridgeMessage(List<StepResult> results) {
        StringBuilder upBridgeBuilder = new StringBuilder();
        StringBuilder downBridgeBuilder = new StringBuilder();

        makeStartOfBridge(upBridgeBuilder, downBridgeBuilder);

        for (StepResult result : results) {
            if (result.isCorrect()) {
                handleCorrect(upBridgeBuilder, downBridgeBuilder, result.getBridgeStep());
            }
            if (!result.isCorrect()) {
                handleFailure(upBridgeBuilder, downBridgeBuilder, result.getBridgeStep());
            }
        }

        makeEndOfBridge(upBridgeBuilder, downBridgeBuilder);

        return makeResult(upBridgeBuilder, downBridgeBuilder);
    }

    private void handleCorrect(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder, BridgeStep bridgeStep) {
        if (bridgeStep == BridgeStep.U) {
            upBridgeBuilder.append(CORRECT);
            downBridgeBuilder.append(SPACE);
        }
        if (bridgeStep == BridgeStep.D) {
            upBridgeBuilder.append(SPACE);
            downBridgeBuilder.append(CORRECT);
        }
    }

    private void handleFailure(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder, BridgeStep bridgeStep) {
        if (bridgeStep == BridgeStep.U) {
            upBridgeBuilder.append(FAIL);
            downBridgeBuilder.append(SPACE);
        }
        if (bridgeStep == BridgeStep.D) {
            upBridgeBuilder.append(SPACE);
            downBridgeBuilder.append(FAIL);
        }
    }

    private String makeResult(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder) {
        return upBridgeBuilder.toString() + System.lineSeparator() + downBridgeBuilder.toString();
    }

    private void makeStartOfBridge(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder) {
        upBridgeBuilder.append(BRIDGE_START);
        downBridgeBuilder.append(BRIDGE_START);
    }

    private void makeEndOfBridge(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder) {
        upBridgeBuilder.append(BRIDGE_END);
        downBridgeBuilder.append(BRIDGE_END);
    }
}
