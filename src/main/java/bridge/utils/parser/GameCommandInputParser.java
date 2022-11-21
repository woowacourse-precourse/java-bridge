package bridge.utils.parser;

import bridge.constant.BridgePhrase;
import bridge.domain.resources.GameCommand;
import bridge.utils.EmptyAndNullChecker;
import java.util.function.Function;
import java.util.stream.Stream;

public class GameCommandInputParser {

    public static GameCommand parseGameCommand(final String input) {
        return parseWithCheckingEmpty(input, GameCommand::from);
    }

    private static <T> T parseWithCheckingEmpty(final String input, final Function<String, T> function) {
        EmptyAndNullChecker.check(input);
        return parse(input, function);
    }

    private static <T> T parse(final String input, final Function<String, T> function) {
        return Stream.of(input)
            .map(String::trim)
            .filter(str -> str.matches("^[A-Z]*$"))
            .map(function)
            .findFirst()
            .orElseThrow(()-> new IllegalArgumentException(BridgePhrase.ERROR_PARSER_GAME_COMMAND.getMessage()));
    }
}
