package bridge;

public class GameInfo {
    private boolean successOrFail;
    private String gameRound;
    private int currentPosition;
    private int trialCount;

    public GameInfo() {
        this.currentPosition = 0;
        this.trialCount = 1;
        this.gameRound = "";
        this.successOrFail = false;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public String getGameRound() {
        return gameRound;
    }

    public boolean getSuccessOrFail() {
        return successOrFail;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setGameRound(String gameRound) {
        this.gameRound = gameRound;
    }

    public void setSuccessOrFail(boolean successOrFail) {
        this.successOrFail = successOrFail;
    }

    public void setTrialCount(int trialCount) {
        this.trialCount = trialCount;
    }
}

