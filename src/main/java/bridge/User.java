package bridge;

import java.util.ArrayList;

public class User {
    private ArrayList<Field> userBridge;
    private int gameCount = 0;

    public int getGameCount() {
        return gameCount;
    }

    public ArrayList<Field> getUserBridge() {
        return userBridge;
    }
}
