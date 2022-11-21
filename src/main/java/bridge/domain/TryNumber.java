package bridge.domain;

public class TryNumber {
    private int tryNumber;

    private TryNumber(int tryNumber) {
        this.tryNumber = tryNumber;
    }
    public static TryNumber zero() {
        return new TryNumber(0);
    }

    public void increase() {
        tryNumber += 1;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
