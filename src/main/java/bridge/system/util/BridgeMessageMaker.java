package bridge.system.util;

import bridge.vo.enums.Step;
import bridge.vo.StepResult;

import java.util.Iterator;
import java.util.List;

public class BridgeMessageMaker {

    public static final String BRIDGE_START = "[";
    public static final String SPACE = "   ";
    public static final String CORRECT = " O ";
    public static final String FAIL = " X ";
    public static final String BRIDGE_END = "]";
    public static final String SEPARATOR = "|";

    public String makeBridgeMessage(List<StepResult> results) {
        StringBuilder upBridgeBuilder = new StringBuilder();
        StringBuilder downBridgeBuilder = new StringBuilder();

        makeBridgeMap(results, upBridgeBuilder, downBridgeBuilder);

        return makeResult(upBridgeBuilder, downBridgeBuilder);
    }

    private void makeBridgeMap(List<StepResult> results, StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder) {
        makeStartOfBridge(upBridgeBuilder, downBridgeBuilder);
        makeStepsOfBridge(results, upBridgeBuilder, downBridgeBuilder);
        makeEndOfBridge(upBridgeBuilder, downBridgeBuilder);
    }

    private void makeStepsOfBridge(List<StepResult> results, StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder) {
        Iterator<StepResult> iterator = results.iterator();
        while (iterator.hasNext()) {
            makeEachStepOfBridge(upBridgeBuilder, downBridgeBuilder, iterator);
        }
    }

    private void makeEachStepOfBridge(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder, Iterator<StepResult> iterator) {
        StepResult result = iterator.next();
        if (result.isCorrect()) {
            handleCorrect(upBridgeBuilder, downBridgeBuilder, result.getBridgeStep());
        }
        if (!result.isCorrect()) {
            handleFailure(upBridgeBuilder, downBridgeBuilder, result.getBridgeStep());
        }
        if (iterator.hasNext()) {
            addSeparator(upBridgeBuilder, downBridgeBuilder);
        }
    }

    private void handleCorrect(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder, Step step) {
        if (step == Step.U) {
            upBridgeBuilder.append(CORRECT);
            downBridgeBuilder.append(SPACE);
        }
        if (step == Step.D) {
            upBridgeBuilder.append(SPACE);
            downBridgeBuilder.append(CORRECT);
        }
    }

    private void handleFailure(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder, Step step) {
        if (step == Step.U) {
            upBridgeBuilder.append(FAIL);
            downBridgeBuilder.append(SPACE);
        }
        if (step == Step.D) {
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

    private void addSeparator(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder) {
        upBridgeBuilder.append(SEPARATOR);
        downBridgeBuilder.append(SEPARATOR);
    }
}
