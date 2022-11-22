package bridge.utils;

import bridge.domain.exception.WrongNumberInputException;
import java.util.stream.Stream;

public class SizeInputParser {

    private SizeInputParser() {

    }

    public static int parseSize(final String input) {
        return parseWithCheckingEmpty(input);
    }

    private static int parseWithCheckingEmpty(final String input) {
        EmptyChecker.check(input);

        return parse(input);
    }

    private static int parse(final String input) {
        return Stream.of(input)
            .map(String::trim)
            .filter(i -> i.matches(Constants.NUMBER_PATTERN))
            .map(Integer::parseInt)
            .findFirst()
            .orElseThrow(WrongNumberInputException::new);
    }

}
