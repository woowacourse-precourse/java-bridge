package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMovable(String input, int squareIndex) {
        String squareInformation = bridge.get(squareIndex);
        return squareInformation.equals(input);
    }

    public boolean isLastIndex(int index) {
        return bridge.size() == index;
    }
}
