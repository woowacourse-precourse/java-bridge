package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BridgeShape {
    DOWN("D", 0),
    UP("U", 1);

    private final String shape;
    private final int number;

    BridgeShape(String shape, int number) {
        this.shape = shape;
        this.number = number;
    }
}
