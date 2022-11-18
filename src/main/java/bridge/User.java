package bridge;

import java.util.ArrayList;

public class User {
    private ArrayList<Field> userBridge = new ArrayList<>();
    private int gameCount = 0;

    public int getGameCount() {
        return gameCount;
    }

    public ArrayList<Field> getUserBridge() {
        return userBridge;
    }
}
