package bridge.domain.trycount;

public class TryCount {

    private static final int START_VALUE = 1;

    private final int count;

    private TryCount(int count) {
        this.count = count;
    }

    public static TryCount start() {
        return new TryCount(START_VALUE);
    }

    public TryCount up() {
        return new TryCount(this.count + 1);
    }
}
