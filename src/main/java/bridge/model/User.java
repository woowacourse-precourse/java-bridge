package bridge.model;

public class User {

    private int tryCount;
    private boolean success;

    public User(int tryCount, boolean success) {
        this.tryCount = tryCount;
        this.success = success;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void addTryCount() {
        tryCount++;
    }

    public void checkSuccess() {
        success = true;
    }
}
