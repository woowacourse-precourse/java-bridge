package bridge.domain;

public class Bridge {
    private String position;
    private boolean crossed = false;

    private Bridge() {
    }

    private Bridge(String position) {
        this.position = position;
    }

    public static Bridge create(String position) {
        return new Bridge(position);
    }

    public boolean isCrossed() {
        return this.crossed;
    }
}
