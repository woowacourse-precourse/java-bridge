package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int tryTime;
    private String state;
    private List<String> bridgeState;

    User() {
        tryTime = 1;
        state = GameState.Playing.getState();
        bridgeState = new ArrayList<String>();
    }

    public int getTryTime() {
        return tryTime;
    }

    public void setTryTime(int tryTime) {
        this.tryTime = tryTime;
    }
    public void addTryTime() {
        tryTime++;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getBridgeState() {
        return bridgeState;
    }

    public void setBridgeState(List<String> bridgeState) {
        this.bridgeState = bridgeState;
    }

    public void addBridgeState(String move) {
        bridgeState.add(move);
    }
}
