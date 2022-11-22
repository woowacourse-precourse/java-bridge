package bridge.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeData {

    private List<String> bridge;
    private List<String> bridgeByUser = new ArrayList<>();
    private int totalAttempt;

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> copyBridge() {
        return List.copyOf(this.bridge);
    }

    public List<String> copyBridgeByUser() {
        return List.copyOf(this.bridgeByUser);
    }

    public int getTotalAttempt() {
        return this.totalAttempt;
    }

    public void increaseAttempts() {
        this.totalAttempt += 1;
    }

    public void initializeTotalAttempt() {
        this.totalAttempt = 1;
    }

    public void initializeBridgeDesignByUser() {
        this.bridgeByUser = new ArrayList<>();
    }

    public void addBridgeDesignByUser(String nextStep) {
        this.bridgeByUser.add(nextStep);
    }

    public void markFailedPointOnBridgeDesignByUser(int indexOfFailedPoint) {
        this.bridgeByUser.set(indexOfFailedPoint, "X");
    }

    public boolean isBridgeAtIndexImpossibleZone(int index, String nextStep) {
        return !Objects.equals(this.bridge.get(index), nextStep);
    }

    public int returnBridgeByUserSize() {
        return this.bridgeByUser.size();
    }

    public boolean isBridgeDesignByUserCompleted() {
        return Objects.equals(bridge, bridgeByUser);
    }
}
