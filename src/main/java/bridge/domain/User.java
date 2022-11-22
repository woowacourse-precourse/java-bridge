package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> bridge;
    private ArrayList<String> userBridge;
    private int numberOfAttempts;


    public User(List<String> bridge) {
        this.userBridge = new ArrayList<>();
        this.bridge = bridge;
        this.numberOfAttempts = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public ArrayList<String> getUserBridge() {
        return userBridge;
    }

    public void setUserBridge(ArrayList<String> userBridge) {
        this.userBridge = userBridge;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public boolean onGame() {
        if (this.userBridge.size() == this.bridge.size()) {
            return false;
        }
        return true;
    }

    public void addMove(String move) {
        this.userBridge.add(move);
    }

    public boolean checkBridge() {
        for (int i = 0; i < this.userBridge.size(); i++) {
            if (!this.userBridge.get(i).equals(this.bridge.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void restartGame() {
        this.numberOfAttempts += 1;
        this.userBridge.clear();
    }
}
