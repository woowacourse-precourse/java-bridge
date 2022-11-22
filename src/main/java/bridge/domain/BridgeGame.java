package bridge.domain;

import static bridge.domain.BridgeSign.*;
import static bridge.domain.MoveSign.UP;

public class BridgeGame {
    private StringBuilder firstRoad = new StringBuilder();
    private StringBuilder secondRoad = new StringBuilder();
    private int roundCount = 1;

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
            correctMove(command);
            return;
        }
        wrongMove(command);
    }

    private void wrongMove(String command) {
        if (command.equals(UP.getMoveContent())) {
            firstRoad.append(MOVE_FAIL.getSign());
            secondRoad.append(SPACE.getSign());
            return;
        }
        firstRoad.append(SPACE.getSign());
        secondRoad.append(MOVE_FAIL.getSign());
    }

    private void correctMove(String command) {
        if (command.equals(UP.getMoveContent())) {
            firstRoad.append(MOVE_SUCCESS.getSign());
            secondRoad.append(SPACE.getSign());
            return;
        }
        firstRoad.append(SPACE.getSign());
        secondRoad.append(MOVE_SUCCESS.getSign());
    }

    public void retry() {
        firstRoad = new StringBuilder();
        secondRoad = new StringBuilder();
        roundCount++;
    }
}
