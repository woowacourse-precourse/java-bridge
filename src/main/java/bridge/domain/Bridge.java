package bridge.domain;

import bridge.view.ExceptionView;
import java.util.List;

public class Bridge {

    public static final int MAX_SIZE = 20;
    public static final int MIN_SIZE = 3;
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        validateSize(bridge.size());
        this.bridge = bridge;
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            ExceptionView.bridgeSizeError();
            throw new IllegalArgumentException();
        }
    }

    public boolean isCrossed(String movingPoint, int index) {
        return movingPoint.equals(bridge.get(index));
    }

    public boolean isSame(List<String> mark) {
        return bridge.equals(mark);
    }
}
