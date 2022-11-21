package bridge.utils;

import bridge.model.BridgeLength;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class BasicBridgeInputNumericParser {

    public static BridgeLength parseBridgeLengthAmount(final String input) {
        return parseNumericCheckingEmpty(input, BridgeLength::from);
    }

    private static <T> T parseNumericCheckingEmpty(final String input, final IntFunction<T> creationFunction) {
        EmptyChecker.check(input);
        return parserWithCheckingOnlyNumeric(input, creationFunction);
    }

    private static <T> T parserWithCheckingOnlyNumeric(final String input, final IntFunction<T> creationFunction) {
        String tmpCheck = input.trim();
        for (int i = 0; i < tmpCheck.length(); i++) {
            if (!"0123456789".contains(tmpCheck.substring(i, i + 1))) {
                throw new IllegalArgumentException("Input is not numeric");
            }
        }
        return parse(input, creationFunction);
    }

    private static <T> T parse(final String input, final IntFunction<T> creationFunction) {
        return Stream.of(input)
            .map(String::trim)
            .map(Integer::parseInt)
            .map(creationFunction::apply)
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
