package bridge;

import java.util.List;

public class Bridge {
    private static final String GO = "O";
    private static final String CANNOT_GO = "X";
    private static final String NOT_GO = " ";
    private static final String OPEN_SQUARE_BRACKETS = "[";
    private static final String CLOSE_SQUARE_BRACKETS = "]";
    private static final String VERTICAL_BAR = "|";

    private List<String> upper;
    private List<String> lower;

    public Bridge(List<String> upper, List<String> lower) {
        this.upper = upper;
        this.lower = lower;
    }

    public void moveUpperBridge() {
        upper.add(GO);
        lower.add(NOT_GO);
    }

    public void moveLowerBridge() {
        upper.add(NOT_GO);
        lower.add(GO);
    }

    public void cannotMoveUpperBridge() {
        upper.add(CANNOT_GO);
        lower.add(NOT_GO);
    }

    public void cannotMoveLowerBridge() {
        upper.add(NOT_GO);
        lower.add(CANNOT_GO);
    }

    private StringBuilder pretty(List<String> bridge) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OPEN_SQUARE_BRACKETS)
                     .append(String.join(VERTICAL_BAR, bridge))
                     .append(CLOSE_SQUARE_BRACKETS);
        return stringBuilder;
    }

    @Override
    public String toString() {
        return pretty(upper).append("\n")
                            .append(pretty(lower))
                            .toString();
    }
}
