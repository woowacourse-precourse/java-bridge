package bridge.utils;

import bridge.domain.MovingCommand;
import bridge.domain.exception.WrongMovingCommandException;
import java.util.function.Function;
import java.util.stream.Stream;

public class CommandInputParser {

    private CommandInputParser() {

    }

    public static MovingCommand parseWithCheckingEmpty(final String input) {
        return parseWithCheckingEmpty(input, MovingCommand::from);
    }

    private static <T> T parseWithCheckingEmpty(final String input,
        final Function<String, T> creationFunction) {
        EmptyChecker.check(input);

        return parse(input, creationFunction);
    }

    private static <T> T parse(final String input, final Function<String, T> creationFunction) {
        return Stream.of(input)
            .map(String::trim)
            .filter(i -> i.matches(Constants.UPPER_PATTERN))
            .map(creationFunction)
            .findFirst()
            .orElseThrow(WrongMovingCommandException::new);
    }

}
