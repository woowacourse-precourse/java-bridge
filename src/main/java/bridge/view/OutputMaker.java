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

        for (int i = 0; i < result.size(); i++) {
            if (bridge.get(i).equals("U")) {
                appendState(upperLayerBuilder, result.get(i));
            } else {
                upperLayerBuilder.append(EMPTY);
            }
        }

        upperLayerBuilder.append(BRIDGE_END);

        return upperLayerBuilder.toString();
    }

    public String makeLowerLayer(List<String> bridge, List<String> result) {
        StringBuilder lowerLayerBuilder = new StringBuilder();

        lowerLayerBuilder.append(BRIDGE_START);

        for (int i = 0; i < result.size(); i++) {
            if (bridge.get(i).equals("D")) {
                appendState(lowerLayerBuilder, result.get(i));
            } else {
                lowerLayerBuilder.append(EMPTY);
            }
        }

        lowerLayerBuilder.append(BRIDGE_END);

        return lowerLayerBuilder.toString();
    }

    private void appendState(StringBuilder builder, String result) {
        if (result.equals("O")) {
            builder.append(CORRECT);
        } else {
            builder.append(WRONG);
        }
    }
}
