package bridge;

import java.util.LinkedList;
import java.util.List;

public class GameData {
    private final LinkedList<String> topStatus = new LinkedList<>();
    private final LinkedList<String> bottomStatus = new LinkedList<>();
    private int totalTry = 1;
    private List<String> bridge;

    public LinkedList<String> getTopStatus() {
        return this.topStatus;
    }

    public LinkedList<String> getBottomStatus() {
        return this.bottomStatus;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getTotalTry() {
        return this.totalTry;
    }

    public void clearStatus() {
        this.topStatus.clear();
        this.bottomStatus.clear();
    }

    public void updateStatus(String moving, String movingResult) {
        if (moving.equals("U")) {
            this.topStatus.add(movingResult);
            this.bottomStatus.add(" ");
        }
        if (moving.equals("D")) {
            this.topStatus.add(" ");
            this.bottomStatus.add(movingResult);
        }
    }

    public void increaseTotalTry() {
        this.totalTry += 1;
    }

}
