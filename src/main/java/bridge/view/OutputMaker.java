package bridge.view;

import java.util.List;

public class OutputMaker {
    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_PARTITION = "|";
    private static final String BRIDGE_END = "]";

    private static final String EMPTY = "   ";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";

    public String makeUpperLayer(List<String> bridge, List<String> result) {
        StringBuilder upperLayerBuilder = new StringBuilder();

        upperLayerBuilder.append(BRIDGE_START);
        fillUpperLayerContents(bridge, result, upperLayerBuilder);
        upperLayerBuilder.append(BRIDGE_END);

        return upperLayerBuilder.toString();
    }

    public String makeLowerLayer(List<String> bridge, List<String> result) {
        StringBuilder lowerLayerBuilder = new StringBuilder();

        lowerLayerBuilder.append(BRIDGE_START);
        fillLowerLayerContents(bridge, result, lowerLayerBuilder);
        lowerLayerBuilder.append(BRIDGE_END);

        return lowerLayerBuilder.toString();
    }

    private void fillUpperLayerContents(List<String> bridge, List<String> result, StringBuilder upperLayerBuilder) {
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).equals("U")) {
                appendState(upperLayerBuilder, bridge.get(i), result.get(i));
            }
            if (result.get(i).equals("D")) {
                upperLayerBuilder.append(EMPTY);
            }
            if (i != result.size() - 1) {
                upperLayerBuilder.append(BRIDGE_PARTITION);
            }
        }
    }

    private void fillLowerLayerContents(List<String> bridge, List<String> result, StringBuilder lowerLayerBuilder) {
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).equals("D")) {
                appendState(lowerLayerBuilder, bridge.get(i), result.get(i));
            }
            if (result.get(i).equals("U")) {
                lowerLayerBuilder.append(EMPTY);
            }
            if (i != result.size() - 1) {
                lowerLayerBuilder.append(BRIDGE_PARTITION);
            }
        }
    }

    private void appendState(StringBuilder builder, String answer, String result) {
        if (result.equals(answer)) {
            builder.append(CORRECT);
            return;
        }
        builder.append(WRONG);
    }
}
