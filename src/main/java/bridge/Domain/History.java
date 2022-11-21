package bridge.Domain;

public class History {
    private final UserBridge upperBridge;
    private final UserBridge lowerBridge;
    private boolean success;
    private int tries;

    public History() {
        this.upperBridge = new UserBridge();
        this.lowerBridge = new UserBridge();
        this.success = false;
        this.tries = 0;
    }

    public UserBridge getUpperBridge() {
        return upperBridge;
    }

    public UserBridge getLowerBridge() {
        return lowerBridge;
    }

    public void move(String upperMove, String lowerMove) {
        upperBridge.saveSpaceResult(upperMove);
        lowerBridge.saveSpaceResult(lowerMove);
    }

    public void gameSuccess() {
        success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void gameTry() {
        tries += 1;
    }

    public int getTries() {
        return tries;
    }

    public void reset() {
        upperBridge.resetSpace();
        lowerBridge.resetSpace();
    }
}
