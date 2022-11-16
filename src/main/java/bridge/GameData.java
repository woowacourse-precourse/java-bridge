package bridge;

import java.util.Arrays;
import java.util.List;

public class GameData {
    private int totalTry = 1;
    private String gameResult;
    private List<String> topStatus;
    private List<String> bottomStatus;

    public List<String> getTopStatus() { return this.topStatus; }
    public List<String> getBottomStatus() { return this.bottomStatus; }

    public int getTotalTry() { return this.totalTry; }

    public void clearStatus() {
        this.topStatus = Arrays.asList("[", "]");
        this.bottomStatus = Arrays.asList("[", "]");
    }

    public void increaseTotalTry() { this.totalTry += 1; }

}
