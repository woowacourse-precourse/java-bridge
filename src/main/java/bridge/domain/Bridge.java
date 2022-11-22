package bridge.domain;

import bridge.view.ExceptionView;
import java.util.List;

public class Bridge {

    public static final int MAX_SIZE = 20;
    public static final int MIN_SIZE = 3;
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge.size());
        this.bridge = bridge;
        System.out.println(bridge);
    }

    private void validate(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            ExceptionView.bridgeRangeError();
            throw new IllegalArgumentException();
        }
    }

    public boolean checkPassable(String movingPoint, int index) {
        return movingPoint.equals(bridge.get(index));
    }

    public boolean isSameBridge(List<String> mark) {
        return bridge.equals(mark);
    }
}
