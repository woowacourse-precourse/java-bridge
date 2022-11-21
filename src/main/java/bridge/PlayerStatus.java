package bridge;

public class PlayerStatus {

    private String step;
    private boolean matchingFlag;

    public PlayerStatus(String step, boolean matchingFlag) {
        this.step = step;
        this.matchingFlag = matchingFlag;
    }

    public String getStep() {
        return step;
    }

    public boolean isMatchingFlag() {
        return matchingFlag;
    }

    public void updateStatus(String step, boolean matchingFlag) {
        this.step = step;
        this.matchingFlag = matchingFlag;
    }
}
