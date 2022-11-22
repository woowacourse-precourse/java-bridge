package bridge;

public class GameStatus {
    private boolean clear;
    private boolean failure;

    public GameStatus(boolean clear, boolean failure) {
        this.clear = clear;
        this.failure = failure;
    }

    public boolean isSuccess(int bridgeSize, int movingSize){
        return !failure && bridgeSize == movingSize;
    }

    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    public boolean isFailure() {
        return failure;
    }

    public void setFailure(boolean failure) {
        this.failure = failure;
    }
}
