package bridge;

import utils.ConstValue;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private final List<String> upperBridgeResult;
    private final List<String> lowerBridgeResult;

    private int currentPosition;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.upperBridgeResult = new ArrayList<>();
        this.lowerBridgeResult = new ArrayList<>();
        this.currentPosition = 0;
    }

    public void initBridge() {
        this.upperBridgeResult.clear();
        this.lowerBridgeResult.clear();
        this.currentPosition = 0;
    }

    public String toString() {
        StringBuilder up = new StringBuilder(ConstValue.START_BRIDGE);
        StringBuilder down = new StringBuilder(ConstValue.START_BRIDGE);

        up.append(String.join(ConstValue.DELIMITER, upperBridgeResult)).append(ConstValue.END_BRIDGE);
        down.append(String.join(ConstValue.DELIMITER, lowerBridgeResult)).append(ConstValue.END_BRIDGE);

        return up.append(ConstValue.LINE_BREAK).append(down).toString();
    }

    public void addUpBridgeResult(String movingPlace) {
        if (canCross(movingPlace) && movingPlace.equals(ConstValue.UPPER_BRIDGE)) {
            upperBridgeResult.add(ConstValue.PASS);
            return;
        }
        upperBridgeResult.add(getOXResult(movingPlace, ConstValue.UPPER_BRIDGE));
    }

    public void addDownBridgeResult(String movingPlace) {
        if (canCross(movingPlace) && movingPlace.equals(ConstValue.LOWER_BRIDGE)) {
            lowerBridgeResult.add(ConstValue.PASS);
            return;
        }
        lowerBridgeResult.add(getOXResult(movingPlace, ConstValue.LOWER_BRIDGE));
    }

    public boolean isCorrect(String movingPlace) {
        String correctBridge = bridge.get(currentPosition);

        if (movingPlace.equals(correctBridge)) {
            move();
            return true;
        }

        return false;
    }

    private void move() {
        currentPosition++;
    }

    private boolean canCross(String movingPlace) {
        String correctBridge = bridge.get(currentPosition);

        return movingPlace.equals(correctBridge);
    }

    private String getOXResult(String movingPlace, String currentBridge) {
        if (!canCross(movingPlace) && movingPlace.equals(currentBridge)) {
            return ConstValue.NOT_PASS;
        }

        return ConstValue.BLANK;
    }

    public boolean isCompleted() {
        return currentPosition == bridge.size();
    }

}
