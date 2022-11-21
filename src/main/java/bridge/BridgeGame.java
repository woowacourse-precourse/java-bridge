package bridge;

import static bridge.input.InputString.UP;

public class BridgeGame {
    private StringBuilder firstRoad = new StringBuilder();
    private StringBuilder secondRoad = new StringBuilder();
    private int roundCount = 1;
    private final String O = "O";
    private final String X = "X";
    private final String SPACE = " ";

    public StringBuilder getFirstRoad() {
        return firstRoad;
    }

    public StringBuilder getSecondRoad() {
        return secondRoad;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void move(String command, boolean isCorrect) {
        if (isCorrect) {
            if (command.equals(UP)) {
                firstRoad.append(O);
                secondRoad.append(SPACE);
                return;
            }
            firstRoad.append(SPACE);
            secondRoad.append(O);
            return;
        }
        if (command.equals(UP)) {
            firstRoad.append(X);
            secondRoad.append(SPACE);
            return;
        }
        firstRoad.append(SPACE);
        secondRoad.append(X);
    }

    public void retry() {
        firstRoad = new StringBuilder();
        secondRoad = new StringBuilder();
        roundCount++;
    }
}
