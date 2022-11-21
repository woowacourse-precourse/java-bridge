package bridge.utils.parser;

import bridge.domain.resources.Move;

import bridge.utils.EmptyAndNullChecker;

import java.util.function.Function;
import java.util.stream.Stream;

public class MoveInputParser {

    public static Move parseMove(final String input) {
        return parseWithEmptyAndNullCheck(input, Move::from);
    }

    private static <T> T parseWithEmptyAndNullCheck(final String input, final Function<String, T> Function) {
        EmptyAndNullChecker.check(input);
        return parseWithApply(input, Function);
    }

    private static <T> T parseWithApply(final String input, final Function<String, T> Function) {
        return Stream.of(input)
            .map(String::trim)
            .filter(str -> str.matches("^[A-Z]*$"))
            .map(Function)
            .findFirst()
            .orElseThrow(()-> new IllegalArgumentException("[ERROR]"));
    }
}
