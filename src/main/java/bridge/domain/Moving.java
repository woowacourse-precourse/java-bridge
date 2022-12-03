package bridge.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Moving {
    UP("U", "위", 1),
    DOWN("D", "아래", 0);

    private final String expression;
    private final String description;
    private final int number;

    private static final Map<Integer, Moving> NUMBERS =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Moving::getNumber, Function.identity())));

    private static final Map<String, Moving> EXPRESSIONS =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Moving::getExpression, Function.identity())));

    Moving(String expression, String description, int number) {
        this.expression = expression;
        this.description = description;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getExpression() {
        return expression;
    }

    public String getDescription() {
        return description;
    }

    public static Moving findByNumber(int number) {
        return NUMBERS.get(number);
    }

    public static Optional<Moving> findByExpression(String expression) {
        return Optional.ofNullable(EXPRESSIONS.get(expression));
    }

}
