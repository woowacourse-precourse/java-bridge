package bridge;

import java.util.List;

public class BridgeGame {

    List<String> bridge;
    Boolean isCorrect;
    Integer bridgeIndex = 0;
    Integer tryNumber = 1;
    Boolean isSuccess = false;

    public BridgeGame(List<String> bridge) {
        bridge.add(" ");
        this.bridge = bridge;
    }

    public void move(String moving) {
        if (!isCorrect(moving)) {
            incorrect();
            return;
        }
        if (canMove()) {
            correct();
            return;
        }
        success();
    }

    public void retry() {
        bridgeIndex--;
        isCorrect = true;
        tryNumber++;
    }

    private boolean isCorrect(String moving) {
        return moving.equals(bridge.get(bridgeIndex));
    }

    private boolean canMove() {
        return (bridgeIndex < bridge.size() - 2);
    }

    private void correct() {
        isCorrect = true;
        bridgeIndex++;
    }

    private void incorrect() {
        isCorrect = false;
        bridgeIndex++;
    }

    private void success() {
        isSuccess = true;
        bridgeIndex++;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public int getBridgeIndex() {
        return bridgeIndex;
    }

    public String getBridgePosition() {
        return bridge.get(bridgeIndex - 1);
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}