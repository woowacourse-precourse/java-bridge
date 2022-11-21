package bridge;

import java.util.LinkedList;

public class GameData {
    public LinkedList<String> topStatus = new LinkedList<>();
    public LinkedList<String> bottomStatus = new LinkedList<>();
    private int totalTry = 1;

    public LinkedList<String> getTopStatus() {
        return this.topStatus;
    }

    public LinkedList<String> getBottomStatus() {
        return this.bottomStatus;
    }

    public int getTotalTry() {
        return this.totalTry;
    }

    public String restartGame() {
        clearStatus();
        increaseTotalTry();

        return "restart";
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
