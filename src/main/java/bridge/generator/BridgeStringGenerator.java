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

        generateMiddleString(footprints, direction, sb);

        sb.append(getLastString(footprints, direction));
        sb.append(" ]\n");
        return sb.toString();
    }

    private String getLastString(List<String> footprints, String direction) {
        if(footprints.size()!=0)return makeLastFigure(footprints.get(footprints.size() - 1), direction);
        return " ";
    }

    private void generateMiddleString(List<String> footprints, String direction, StringBuilder sb) {
        for (int j = 0; j < footprints.size() - 1; j++) {
            sb.append(makeCircleString(footprints.get(j), direction));
            sb.append(" | ");
        }
    }

    protected String makeCircleString(String footprintDirection, String checkDirection) {
        if (footprintDirection.equals(checkDirection)) {
            return "O";
        }
        return " ";
    }

    public abstract String makeLastFigure(String footprintDirection, String checkDirection);
}
