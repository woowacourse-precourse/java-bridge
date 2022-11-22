package bridge;

import java.util.ArrayList;

public class User {
    private ArrayList<Field> recentUserBridge = new ArrayList<>();
    private ArrayList<Field> userBridge = new ArrayList<>();
    private int gameCount = 0;

    public ArrayList<Field> getRecentUserBridge() {
        return recentUserBridge;
    }
    public ArrayList<Field> getUserBridge() {
        return userBridge;
    }
    public int getGameCount() {
        return gameCount;
    }

    public void increaseGameCount(){
        gameCount+=1;
    }

    public void updateBridge(){
        recentUserBridge.clear();
        recentUserBridge.addAll(userBridge);
    }

    public void restoreBridge(){
        userBridge.clear();
        userBridge.addAll(recentUserBridge);
    }



}
