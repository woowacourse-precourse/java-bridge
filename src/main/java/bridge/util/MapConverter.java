package bridge.util;

import java.util.List;

public class MapConverter {
    private static final String START = "[";
    private static final String DELIMITER = "|";
    private static final String END = "]";

    private MapConverter() {
    }

    public static String convertToMap(List<String> crossedBridge) {
        StringBuilder builder = new StringBuilder(START);
        crossedBridge.forEach(mark -> builder.append(convertToInnerMark(mark)));
        builder.deleteCharAt(builder.length() - 1)
                .append(END);
        return builder.toString();
    }

    private static StringBuilder convertToInnerMark(String mark) {
        StringBuilder builder = new StringBuilder(" ");
        builder.append(mark)
                .append(" ")
                .append(DELIMITER);
        return builder;
    }
}
