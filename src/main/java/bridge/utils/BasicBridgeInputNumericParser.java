package bridge.utils;

import bridge.model.BridgeLength;
import java.util.stream.Stream;
import java.util.function.IntFunction;

public class BasicBridgeInputNumericParser {

    private static final String DECIMALS = "0123456789";

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
            if (!DECIMALS.contains(tmpCheck.substring(i, i + 1))) {
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
