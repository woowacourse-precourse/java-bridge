package bridge.view.output;

import java.util.List;

public enum OutputFormatter {
    LEFT_BRACKET("[ "),
    VERTICAL_BAR(" | "),
    RIGHT_BRACKET("]"),
    ;

    private static final int OFFSET = 2;

    private final String symbol;

    OutputFormatter(String symbol) {
        this.symbol = symbol;
    }

    public static String format(List<String> bridgeMap) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(LEFT_BRACKET.symbol);
        bridgeMap.forEach(bridge -> {
            stringBuilder.append(bridge);
            stringBuilder.append(VERTICAL_BAR.symbol);
        });
        removeLastVerticalBar(stringBuilder);
        stringBuilder.append(RIGHT_BRACKET.symbol);
        return stringBuilder.toString();
    }

    private static void removeLastVerticalBar(StringBuilder stringBuilder) {
        stringBuilder.delete(
                stringBuilder.length() - OFFSET,
                stringBuilder.length()
        );
    }
}
