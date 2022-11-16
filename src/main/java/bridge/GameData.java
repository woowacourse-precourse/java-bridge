package bridge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GameData {
    private int totalTry = 1;
    private String gameResult;
    private LinkedList<String> topStatus = new LinkedList<>();
    private LinkedList<String> bottomStatus = new LinkedList<>();

    public LinkedList<String> getTopStatus() { return this.topStatus; }
    public LinkedList<String> getBottomStatus() { return this.bottomStatus; }

    public int getTotalTry() { return this.totalTry; }

    public void clearStatus() {
        this.topStatus.clear();
        this.bottomStatus.clear();
    }

    public void increaseTotalTry() { this.totalTry += 1; }

}
