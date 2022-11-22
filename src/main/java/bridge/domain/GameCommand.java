package bridge.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GameCommand {
    RETRY("R", "재시작"),
    QUIT("Q", "종료");

    private final String expression;
    private final String description;

    private static final Map<String, GameCommand> EXPRESSIONS =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(GameCommand::getExpression, Function.identity())));

    GameCommand(String expression, String description) {
        this.expression = expression;
        this.description = description;
    }

    public String getExpression() {
        return expression;
    }

    public String getDescription() {
        return description;
    }

    public static Optional<GameCommand> findByExpression(String expression) {
        return Optional.ofNullable(EXPRESSIONS.get(expression));
    }
}
