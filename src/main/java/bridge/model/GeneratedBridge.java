package bridge.model;

import java.util.List;

public class GeneratedBridge {

    private final List<String> shape;

    public GeneratedBridge(List<String> bridgeShape) {
        this.shape = bridgeShape;
    }

    private boolean canMoveNextStep(int nextStepIndex, String inputNextStep) {
        String nextStep = shape.get(nextStepIndex);
        return nextStep.equals(inputNextStep);
    }
}
