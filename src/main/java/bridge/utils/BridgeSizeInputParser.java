package bridge.utils;

import bridge.domain.SizeOfBridge;
import bridge.domain.exception.WrongNumberInputException;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class BridgeSizeInputParser {

    private BridgeSizeInputParser() {

    }

    public static SizeOfBridge parseSizeOfBridge(final String input) {
        return parseWithCheckingEmpty(input, SizeOfBridge::from);
    }

    private static <T> T parseWithCheckingEmpty(final String input,
        final IntFunction<T> creationFunction) {
        EmptyChecker.check(input);

        return parse(input, creationFunction);
    }

    private static <T> T parse(final String input, final IntFunction<T> creationFunction) {
        return Stream.of(input)
            .map(String::trim)
            .filter(i -> i.matches(Constants.NUMBER_PATTERN))
            .map(Integer::parseInt)
            .map(creationFunction::apply)
            .findFirst()
            .orElseThrow(WrongNumberInputException::new);
    }

}
