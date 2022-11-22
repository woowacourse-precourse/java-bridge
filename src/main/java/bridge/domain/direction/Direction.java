package bridge.domain.direction;

import java.util.Map;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toUnmodifiableMap;

public enum Direction {

    UP("U", 1),
    DOWN("D", 0),
    ;

    private static final String NOT_MATCH_SYMBOL_BY_NUMBER = "%d에 대응되는 심볼이 없습니다.";
    private static final String NOT_MATCH_DIRECTION_BY_SYMBOL = "%s 에 대응되는 방향이 없습니다.";

    private static final Map<String, Direction> BY_SYMBOL =
            stream(values()).collect(toUnmodifiableMap(Direction::symbol, direction -> direction));

    private static final Map<Integer, String> NUMBER_TO_SYMBOL =
            stream(values()).collect(toUnmodifiableMap(Direction::mappingNumber, Direction::symbol));

    private final String symbol;
    private final int mappingNumber;

    Direction(final String symbol, final int mappingNumber) {
        this.symbol = symbol;
        this.mappingNumber = mappingNumber;
    }

    public static String mapNumberToSymbol(final int number) {
        return ofNullable(NUMBER_TO_SYMBOL.get(number))
                .orElseThrow(() -> new IllegalArgumentException(format(NOT_MATCH_SYMBOL_BY_NUMBER, number)));
    }

    public static Direction ofSymbol(final String symbol) {
        return ofNullable(BY_SYMBOL.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException(format(NOT_MATCH_DIRECTION_BY_SYMBOL, symbol)));
    }

    public String symbol() {
        return symbol;
    }

    public int mappingNumber() {
        return mappingNumber;
    }
}
