package bridge.domain;

import bridge.utils.enums.Moving;

public class RealTimeBridge {

    private static final String BLANK = "";
    private static final String SPACE = "   ";
    private static final String DIVIDE = "|";

    String[][] realTimeBridge = {{"[", "", "]"}
            , {"[", "", "]"}};

    public String[][] getMap() {
        return realTimeBridge;
    }

    public void makeRealTimeBridge(String userMove, String moveResult) {
        if (userMove.equals(Moving.UP.getValue())) {
            moveUpper(moveResult);
            return;
        }
        moveDown(moveResult);
    }

    private void moveDown(String moveResult) {
        if (realTimeBridge[0][1].equals(BLANK)) {
            realTimeBridge[1][1] += moveResult;
            realTimeBridge[0][1] += SPACE;
            return;
        }
        realTimeBridge[1][1] += DIVIDE + moveResult;
        realTimeBridge[0][1] += DIVIDE + SPACE;
    }

    private void moveUpper(String moveResult) {
        if (realTimeBridge[0][1].equals(BLANK)) {
            realTimeBridge[0][1] += moveResult;
            realTimeBridge[1][1] += SPACE;
            return;
        }
        realTimeBridge[0][1] += DIVIDE + moveResult;
        realTimeBridge[1][1] += DIVIDE + SPACE;
    }

    public void initialize() {
        realTimeBridge[0][1] = BLANK;
        realTimeBridge[1][1] = BLANK;
    }
}
