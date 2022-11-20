package bridge.generator;

import java.util.List;

public abstract class BridgeStringGenerator {
    private static final String UP = "U";
    private static final String DOWN = "D";

    public String generate(List<String> footprints) {
        return getUpBridgeString(footprints) + getDownBridgeString(footprints);
    }

    private String getUpBridgeString(List<String> footprints) {
        return makeBridgeString(footprints, UP);
    }

    private String getDownBridgeString(List<String> footprints) {
        return makeBridgeString(footprints, DOWN);
    }

    private String makeBridgeString(List<String> footprints, String direction) {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");

        for (int j = 0; j < footprints.size() - 1; j++) {
            sb.append(makeCircleString(footprints.get(j), direction));
            sb.append(" | ");
        }

        sb.append(makeLastFigure(footprints.get(footprints.size() - 1), direction));
        sb.append(" ]\n");
        return sb.toString();
    }

    protected String makeCircleString(String footprintDirection, String checkDirection) {
        if (footprintDirection.equals(checkDirection)) {
            return "O";
        }
        return " ";
    }

    public abstract String makeLastFigure(String footprintDirection, String checkDirection);
}
