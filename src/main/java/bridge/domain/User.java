package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> bridge;
    private ArrayList<String> userBridge;


    public User(List<String> bridge) {
        this.userBridge = new ArrayList<>();
        this.bridge = bridge;
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
                this.userBridge.clear();
                return true;
            }
        }
        return false;
    }
}
