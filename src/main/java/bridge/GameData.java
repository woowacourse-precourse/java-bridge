package bridge;

import java.util.Arrays;
import java.util.List;

public class GameData {
    private int totalTry = 0;
    private String gameResult;
    private List<String> topStatus;
    private List<String> bottomStatus;

    public List<String> getTopStatus() { return this.topStatus; }
    public List<String> getBottomStatus() { return this.bottomStatus; }

    public void clearStatus() {
        this.topStatus = Arrays.asList("[", "]");
        this.bottomStatus = Arrays.asList("[", "]");
    }

}
