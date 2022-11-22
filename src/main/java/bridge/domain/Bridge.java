package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private static final String ERROR_BRIDGE_SIZE = "다리 길이는 %d부터 %d 사이의 숫자여야 합니다.%n";
    private static final int LOWER_INCLUSIVE = 3;
    private static final int UPPER_INCLUSIVE = 20;
    private final List<Step> bridge;
    private int currentPosition;

    public Bridge(List<String> stringBridge) {
        validate(stringBridge.size());
        this.bridge = transformStringToStep(stringBridge);
        retry();
    }

    private List<Step> transformStringToStep(List<String> stringBridge) {
        List<Step> stepBridge = new ArrayList<>();
        for (String stringStep : stringBridge) {
            stepBridge.add(Step.findByUserInputDirection(stringStep));
        }
        return stepBridge;
    }

    public static void validate(int size) {
        if (LOWER_INCLUSIVE <= size && size <= UPPER_INCLUSIVE) {
            return;
        }
        throw new IllegalArgumentException(String.format(ERROR_BRIDGE_SIZE, LOWER_INCLUSIVE, UPPER_INCLUSIVE));
    }

    public boolean move(Step to) {
        if (isPossibleToMove(to)) {
            currentPosition++;
            return true;
        }
        return false;
    }

    private boolean isPossibleToMove(Step to) {
        Step currentStep = getStepAtCurrentPosition();
        if (currentStep == null) {
            return false;
        }
        return currentStep.equals(to);
    }

    private Step getStepAtCurrentPosition() {
        if (isFinished()) {
            return null;
        }
        return bridge.get(currentPosition);
    }

    public boolean isFinished() {
        return currentPosition >= bridge.size();
    }

    public void retry() {
        this.currentPosition = 0;
    }
}
