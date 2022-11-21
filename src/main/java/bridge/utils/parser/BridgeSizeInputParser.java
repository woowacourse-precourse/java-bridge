package bridge.utils.parser;

import bridge.domain.resources.bridge.BridgeSize;

import bridge.utils.EmptyAndNullChecker;

import java.util.function.IntFunction;
import java.util.stream.Stream;

public class BridgeSizeInputParser {

    public static BridgeSize parseBridgeSize(final String input) {
        return parseWithEmptyAndNullCheck(input, BridgeSize::from);
    }

    private static <T> T parseWithEmptyAndNullCheck(final String input, final IntFunction<T> function) {
        EmptyAndNullChecker.check(input);
        return parseWithApply(input, function);
    }

    private static <T> T parseWithApply(final String input, final IntFunction<T> function) {
        return Stream.of(input)
            .map(String::trim)
            .filter(str -> str.matches("^[0-9]*$"))
            .map(Integer::parseInt)
            .map(function::apply)
            .findFirst()
            .orElseThrow(()-> new IllegalArgumentException("[ERROR]"));
    }
}
