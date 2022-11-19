package bridge.domain;

import bridge.utils.enums.Moving;

public class RealTimeBridge {

    private final String BLANK ="";
    private final String SPACE = "   ";
    private final String DIVIDE = "|";

    String[][] realTimeBridge = {{"[", "", "]"}
            , {"[", "", "]"}};

    public String[][] getMap() {
        return realTimeBridge;
    }

    public String[][] makeRealTimeBridge(String userMove, String bridgeText) {
        if (userMove.equals(Moving.UP.getValue())) {
            return moveUpper(bridgeText);
        }
        return moveDown(bridgeText);
    }

    private String[][] moveDown(String bridgeText) {
        if (realTimeBridge[0][1].equals(BLANK)) {
            realTimeBridge[1][1] += bridgeText;
            realTimeBridge[0][1] += SPACE;
            return realTimeBridge;
        }
        realTimeBridge[1][1] += DIVIDE + bridgeText;
        realTimeBridge[0][1] += DIVIDE + SPACE;
        return realTimeBridge;
    }

    private String[][] moveUpper(String bridgeText) {
        if (realTimeBridge[0][1].equals(BLANK)) {
            realTimeBridge[0][1] += bridgeText;
            realTimeBridge[1][1] += SPACE;
            return realTimeBridge;
        }
        realTimeBridge[0][1] += DIVIDE + bridgeText;
        realTimeBridge[1][1] += DIVIDE + SPACE;
        return realTimeBridge;
    }

    public void initialize() {
        realTimeBridge[0][1] = BLANK;
        realTimeBridge[1][1] = BLANK;
    }
}
