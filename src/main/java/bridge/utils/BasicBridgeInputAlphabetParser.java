package bridge.utils;

import bridge.model.BridgeGame;

public class BasicBridgeInputAlphabetParser {

    public static BridgeGame parseBridgeGameInput(final String input, int mode) {
        return parseWithCheckingEmpty(input, mode);
    }

    private static BridgeGame parseWithCheckingEmpty(final String input, int mode) {
        EmptyChecker.check(input);
        return parse(input, mode);
    }

    private static BridgeGame parse(final String input, int mode) {
        if (input.length() != 1 || !(input.charAt(0) >= 'A' && input.charAt(0) <= 'Z')) {
            throw new IllegalArgumentException("input Alphabet is not Valid");
        }
        return BridgeGame.from(input, mode);
    }
}
