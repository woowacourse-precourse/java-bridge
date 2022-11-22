package bridge.Service;

import bridge.Model.GameResult;

public class BridgeGame {

    private static final String SUCCESS = GameResult.SUCCESS.getResult();

    public int move(int progress) {
        progress += 1;

        return progress;
    }

    public int retry(int totalTries) {
        totalTries += 1;

        return totalTries;
    }

    public boolean isCrossable(String currentResult) {
        if (currentResult.equals(SUCCESS)) {
            return true;
        }
        return false;
    }
}
