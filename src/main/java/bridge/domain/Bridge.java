package bridge.domain;

public class Bridge {

    private final int size;
    private final int MAX_SIZE = 20;
    private final int MIN_SIZE = 3;

    public Bridge(int size) {
        validateSize(size);
        this.size = size;
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
