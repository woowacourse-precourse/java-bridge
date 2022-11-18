package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final int size;
    private int location = 0;
    private int tryCount = 0;

    public Bridge(List<String> bridge, int size) {
        this.bridge = bridge;
        this.size = size;
    }

    public boolean possibleMove(String moving) {
        return getAnswer(location).equals(moving);
    }

    public void locationUpdate() {
        this.location++;
    }

    public void tryCountUpdate() {
        this.tryCount++;
    }

    private String getAnswer(int current) {
        return this.bridge.get(current);
    }
}
