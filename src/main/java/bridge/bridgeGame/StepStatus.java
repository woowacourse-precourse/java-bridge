package bridge.bridgeGame;

import bridge.enums.UpDown;

public class StepStatus {
    private UpDown upDown;
    private boolean isCorrect;

    public StepStatus(UpDown upDown, boolean isCorrect) {
        this.upDown = upDown;
        this.isCorrect = isCorrect;
    }

    public UpDown getUpDown() {
        return upDown;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
