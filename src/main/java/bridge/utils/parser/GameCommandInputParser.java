package bridge.utils.parser;

import bridge.constant.BridgePhrase;
import bridge.domain.resources.GameCommand;
import bridge.utils.EmptyAndNullChecker;
import java.util.stream.Stream;
import java.util.function.Function;

public class GameCommandInputParser {

    public static GameCommand parseGameCommand(final String input) {
        return parseWithCheckingEmpty(input, GameCommand::from);
    }

    private static <T> T parseWithCheckingEmpty(final String input, final Function<String, T> function) {
        EmptyAndNullChecker.check(input);
        return parseWithApply(input, function);
    }

    private static <T> T parseWithApply(final String input, final Function<String, T> function) {
        return Stream.of(input)
                .map(String::trim)
                .filter(str -> str.matches("^[A-Z]*$"))
                .map(function)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(BridgePhrase.ERROR_PARSER_GAME_COMMAND.getMessage()));
    }
}
