package bridge.utils;

import bridge.model.BridgeGame;

public class BasicBridgeInputAlphabetParser {

    private static final Character UPPER_A = 'A';
    private static final Character UPPER_Z = 'Z';


    public static BridgeGame parseBridgeGameInput(final String input, final int mode) {
        return parseWithCheckingEmpty(input, mode);
    }

    private static BridgeGame parseWithCheckingEmpty(final String input, final int mode) {
        EmptyChecker.check(input);
        return parse(input, mode);
    }

    private static BridgeGame parse(final String input, final int mode) {
        if (input.length() != 1 || !(input.charAt(0) >= UPPER_A && input.charAt(0) <= UPPER_Z)) {
            throw new IllegalArgumentException("input Alphabet is not Valid");
        }
        return BridgeGame.from(input, mode);
    }
}
