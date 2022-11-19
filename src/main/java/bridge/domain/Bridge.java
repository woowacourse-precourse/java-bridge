package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMoveable(String input, int squareIndex) {
        String squareInformation = bridge.get(squareIndex);
        return squareInformation.equals(input);
    }
}
