package bridge.model;

public class TryNumber {
    private Integer tryNumber = 1;

    public void addAttemptNumber() {
        tryNumber++;
    }

    public Integer getTryNumber() {
        return tryNumber;
    }
}
