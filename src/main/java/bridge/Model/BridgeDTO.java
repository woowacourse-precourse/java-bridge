package bridge.Model;

import java.util.ArrayList;
import java.util.List;

public class BridgeDTO {
    private List<String> bridge;
    private int size;
    private int movePoint = 0;
    private final List<String> saveFirstLine = new ArrayList<>();
    private final List<String> saveSecondLine = new ArrayList<>();
    private int retry = 1;

    public List<String> getBridge() {
        return this.bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMovePoint() {
        return this.movePoint;
    }

    public void setMovePoint(int movePoint) {
        this.movePoint = movePoint;
    }

    public List<String> getSaveFirstLine() {
        return this.saveFirstLine;
    }

    public List<String> getSaveSecondLine() {
        return this.saveSecondLine;
    }

    public void clearInitializeLine() {
        this.saveFirstLine.clear();
        this.saveSecondLine.clear();
    }

    public int getRetry() {
        return this.retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }
}
