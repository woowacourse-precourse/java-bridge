package bridge;

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

    public void print() {
        for (String one : bridge) {
            System.out.print(one + " ");
        }
    }

    public void initBridge() {
        this.upperBridgeResult.remove(upperBridgeResult.size() - 1);
        this.lowerBridgeResult.remove(lowerBridgeResult.size() - 1);
    }

    public String toString() {
        StringBuilder up = new StringBuilder("[");
        StringBuilder down = new StringBuilder("[");

        up.append(String.join("|", upperBridgeResult)).append("]");
        down.append(String.join("|", lowerBridgeResult)).append("]");

        return up.append("\n").append(down).toString();
    }

    public boolean move(String movingPlace) {
        addUpBridgeResult(movingPlace);
        addDownBridgeResult(movingPlace);

        return isCorrect(movingPlace);
    }

    private void addUpBridgeResult(String movingPlace) {
        if (canCross(movingPlace) && movingPlace.equals("U")) {
            upperBridgeResult.add(" O ");
            return;
        }
        upperBridgeResult.add(getOXResult(movingPlace, "U"));
    }

    private void addDownBridgeResult(String movingPlace) {
        if (canCross(movingPlace) && movingPlace.equals("D")) {
            lowerBridgeResult.add(" O ");
            return;
        }
        lowerBridgeResult.add(getOXResult(movingPlace, "D"));
    }

    private boolean isCorrect(String movingPlace) {
        String correctBridge = bridge.get(currentPosition);

        if (movingPlace.equals(correctBridge)) {
            currentPosition++;
            return true;
        }

        return false;
    }

    private boolean canCross(String movingPlace) {
        String correctBridge = bridge.get(currentPosition);

        return movingPlace.equals(correctBridge);
    }

    private String getOXResult(String movingPlace, String currentBridge) {
        if (!canCross(movingPlace) && movingPlace.equals(currentBridge)) {
            return " X ";
        }

        return "   ";
    }

    public boolean isCompleted() {
        return currentPosition == bridge.size();
    }

}
