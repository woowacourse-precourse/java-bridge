package bridge.domain;

import java.util.HashMap;

public class User {

    private static HashMap<Integer, String> pastResult;
    public int currentBlock;
    private boolean isGameClear = true;
    private boolean isRestartGame = true;

    public User() {
        pastResult = new HashMap<>();
    }

    public boolean changeStatusIsFailed(boolean result) {
        if (!result) {
            isGameClear = false;
            isRestartGame = false;
            return true;
        }
        isGameClear = true;
        isRestartGame = true;
        return false;
    }

    public void addBridgeInfo(int step, String movingBlock) {
        pastResult.put(step, movingBlock);
    }

    public HashMap<Integer, String> getPastResult() {
        return pastResult;
    }
}
