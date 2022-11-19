package bridge.domain;


public class RealTimeBridge {

    String[][] realTimeBridge = {{"[", "", "]"}
            , {"[", "", "]"}};

    public String[][] getMap() {
        return realTimeBridge;
    }

    public String[][] makeRealTimeBridge(String userMove, String bridgeText) {
        if (userMove.equals("U")) {
            return moveUpper(bridgeText);
        }
        return moveDown(bridgeText);
    }

    private String[][] moveDown(String bridgeText) {
        if (realTimeBridge[0][1].equals("")) {
            realTimeBridge[1][1] += bridgeText;
            realTimeBridge[0][1] += "   ";
            return realTimeBridge;
        }
        realTimeBridge[1][1] += "|" + bridgeText;
        realTimeBridge[0][1] += "|" + "   ";
        return realTimeBridge;
    }

    private String[][] moveUpper(String bridgeText) {
        if (realTimeBridge[0][1].equals("")) {
            realTimeBridge[0][1] += bridgeText;
            realTimeBridge[1][1] += "   ";
            return realTimeBridge;
        }
        realTimeBridge[0][1] += "|" + bridgeText;
        realTimeBridge[1][1] += "|" + "   ";
        return realTimeBridge;
    }

    public void initialize() {
        realTimeBridge[0][1] = "";
        realTimeBridge[1][1] = "";
    }
}
