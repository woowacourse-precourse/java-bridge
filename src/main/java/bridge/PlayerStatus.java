package bridge;

public class PlayerStatus {

    private String step;
    private boolean matchingFlag;

    public PlayerStatus(final String step, final boolean matchingFlag) {
        this.step = step;
        this.matchingFlag = matchingFlag;
    }

    public String getStep() {
        return step;
    }

    public boolean isMatchingFlag() {
        return matchingFlag;
    }

    public void updateStatus(final String step, final boolean matchingFlag) {
        this.step = step;
        this.matchingFlag = matchingFlag;
    }
}
