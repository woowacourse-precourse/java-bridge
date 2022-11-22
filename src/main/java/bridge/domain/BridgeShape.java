package bridge.domain;

import java.util.List;

public enum BridgeShape {
    COLLECT_UP(List.of(" O |", "   |"), List.of(" O ", "   ")),
    COLLECT_DOWN(List.of("   |", " O |"), List.of("   ", " O ")),
    WRONG_UP(List.of(" X |", "   |"), List.of(" X ", "   ")),
    WRONG_DOWN(List.of("   |", " X |"), List.of("  ", " X "));

    private List<String> shape;
    private List<String> lastShape;

    BridgeShape(List<String> shape, List<String> lastShape) {
        this.shape = shape;
        this.lastShape = lastShape;
    }

    public List<String> getShapeMessages(boolean isLast) {
        if (isLast) {
            return lastShape;
        }
        return shape;
    }

}
