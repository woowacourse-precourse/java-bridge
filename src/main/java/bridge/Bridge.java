package bridge;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isCorrect(int position, Direction direction) {
        return bridge.get(position).equals(direction.name());
    }
}
