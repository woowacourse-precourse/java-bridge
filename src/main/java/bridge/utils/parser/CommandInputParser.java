package bridge.utils.parser;

import bridge.domain.command.GameCommand;
import bridge.domain.command.MovingCommand;
import bridge.domain.exception.WrongMovingCommandException;

import bridge.utils.Constants;

import java.util.function.Function;
import java.util.stream.Stream;

public class CommandInputParser {

    private CommandInputParser() {
    }

    public static MovingCommand parseMovingCommand(final String input) {
        return parseWithEmptyCheck(input, MovingCommand::from);
    }

    public static GameCommand parseGameCommand(final String input) {
        return parseWithEmptyCheck(input, GameCommand::from);
    }

    private static <T> T parseWithEmptyCheck(final String input,
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
