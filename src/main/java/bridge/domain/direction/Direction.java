package bridge.domain.direction;

import static java.lang.String.format;
import static java.util.Arrays.stream;

public enum Direction {

    UP("U", 1),
    DOWN("D", 0),
    ;

    private static final String NOT_MATCH_SYMBOL_BY_NUMBER = "%d에 대응되는 심볼이 없습니다.";
    private static final String NOT_MATCH_DIRECTION_BY_SYMBOL = "%s 에 대응되는 방향이 없습니다.";
    private final String symbol;
    private final int mappingNumber;

    Direction(final String symbol, final int mappingNumber) {
        this.symbol = symbol;
        this.mappingNumber = mappingNumber;
    }

    public static String mapNumberToSymbol(final int number) {
        return stream(values())
                .filter(direction -> direction.mappingNumber == number)
                .map(direction -> direction.symbol)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(format(NOT_MATCH_SYMBOL_BY_NUMBER, number)));
    }

    public static Direction ofSymbol(final String symbol) {
        return stream(values())
                .filter(direction -> direction.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(format(NOT_MATCH_DIRECTION_BY_SYMBOL, symbol)));
    }
}
