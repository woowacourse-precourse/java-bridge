package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isAvailableSquare(String upOrDown, int squareIndex) {
        String squareInformation = bridge.get(squareIndex);
        return squareInformation.equals(upOrDown);
    }

    public boolean isLastIndex(int index) {
        return bridge.size() == index;
    }
}
