package bridge.domain.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum CrossedState {
    POSSIBLE(true, "O"),
    IMPOSSIBLE(false, "X");
    private final boolean crossingResult;
    private final String successStateSymbol;

    CrossedState(boolean crossingResult, String successStateSymbol) {
        this.crossingResult = crossingResult;
        this.successStateSymbol = successStateSymbol;
    }

    private static boolean isSameBridgeState(CrossedState crossedState, boolean crossingResult) {
        return crossedState.crossingResult == crossingResult;
    }

    public static CrossedState findByCrossingResult(boolean crossingResult) {
        return Arrays.stream(CrossedState.values())
                .filter(crossingState -> isSameBridgeState(crossingState, crossingResult))
                .findAny().orElseThrow(NoSuchElementException::new);
    }

    public static String transform(boolean crossingResult) {
        CrossedState crossedState = findByCrossingResult(crossingResult);
        if (crossedState == null) {
            throw new NullPointerException();
        }
        return crossedState.successStateSymbol;
    }
}
