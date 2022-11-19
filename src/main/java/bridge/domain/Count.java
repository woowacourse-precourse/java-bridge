package bridge.domain;

public class Count {
    private final int count;

    public Count() {
        this(1);
    }

    public Count(int count) {
        this.count = count;
    }

    public Count increase() {
        return new Count(this.count + 1);
    }

    public String printCount() {
        return String.valueOf(this.count);
    }
}
