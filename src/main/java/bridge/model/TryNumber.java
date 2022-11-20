package bridge.model;

public class TryNumber {
    private Integer tryNumber = 1;

    public void addAttemptNumber() {
        tryNumber += 1;
    }

    public Integer getTryNumber() {
        return tryNumber;
    }
}
