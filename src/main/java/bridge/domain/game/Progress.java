package bridge.domain.game;

import bridge.domain.generator.Step;

import java.util.*;
import java.util.stream.Collectors;

public class Progress {
    private Map<String, List<String>> bridgeShape = new LinkedHashMap<>();

    public Progress() {
        this.bridgeShape.put(Step.UPPER_STEP.getStepTxt(), new ArrayList<>());
        this.bridgeShape.put(Step.LOWER_STEP.getStepTxt(), new ArrayList<>());
    }

    public String saveProgress(SuccessStep successStep, String userStep) {
        makeBridge(successStep, userStep);
        return finalBridge();
    }

    private void makeBridge(SuccessStep successStep, String userStep) {
        bridgeShape.forEach((updown, bridge) ->
                bridge.add(decideStructure(userStep, successStep, updown)));
    }

    private String decideStructure(String userStep, SuccessStep successStep, String updown) {
        if (userStep.equals(updown)) {
            return successStep.getStep();
        }
        return BridgeStructure.BRIDGE_EMPTY.getShape();
    }

    private String makeEachRow(List<String> row) {
        String bridgeCell = row.stream().collect(Collectors.joining(BridgeStructure.BRIDGE_CELL.getShape()));
        return BridgeStructure.BRIDGE_START.getShape() + bridgeCell + BridgeStructure.BRIDGE_END.getShape();
    }

    private String finalBridge() {
        StringBuilder sb = new StringBuilder();
        for (List<String> row : bridgeShape.values()) {
            sb.append(makeEachRow(row));
            sb.append(BridgeStructure.BRIDGE_ROW.getShape());
        }
        return sb.toString();
    }


}
