package bridge.utils;

import bridge.model.BridgeLength;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class BasicBridgeInputNumericParser {


    private BasicBridgeInputNumericParser() {

    }

    public static BridgeLength parseBridgeLengthAmount(final String input) {
        return parseWithCheckingEmpty(input, BridgeLength::from);
    }

    private static <T> T parseWithCheckingEmpty(final String input, final IntFunction<T> creationFunction) {
        EmptyChecker.check(input);
        return parse(input , creationFunction);
    }

    private static <T> T parse(final String input, final IntFunction<T> creationFunction) {
        return Stream.of(input)
            .map(String::trim)
            .map(Integer::parseInt)             //이거는 고치자.
            .map(creationFunction::apply)
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
