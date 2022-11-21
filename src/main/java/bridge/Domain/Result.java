package bridge.Domain;

import java.util.List;

public class Result {
    private final UserBridge upperBridge;
    private final UserBridge lowerBridge;
    private boolean success;
    private int tries;

    public Result() {
        this.upperBridge = new UserBridge();
        this.lowerBridge = new UserBridge();
        this.success = false;
        this.tries = 0;
    }

    public List<String> getUpperSpaces() {
        return upperBridge.getSpaces();
    }

    public List<String> getLowerSpaces() {
        return lowerBridge.getSpaces();
    }

    public void saveMove(String upperMove, String lowerMove) {
        upperBridge.saveSpace(upperMove);
        lowerBridge.saveSpace(lowerMove);
    }

    public void resetSpaces() {
        upperBridge.resetSpace();
        lowerBridge.resetSpace();
    }

    public boolean isSuccess() {
        return success;
    }

    public void gameSucceed() {
        success = true;
    }

    public int getTries() {
        return tries;
    }

    public void tryOneMore() {
        tries += 1;
    }
}
