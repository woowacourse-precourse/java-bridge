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
}
