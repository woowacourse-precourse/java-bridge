package bridge.domain.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum CrossedState {
    POSSIBLE(true, "O", "성공"),
    IMPOSSIBLE(false, "X", "실패");
    private final boolean crossingResult;
    private final String successStateSymbol;
    private final String successStateWord;

    CrossedState(boolean crossingResult, String successStateSymbol, String successStateWord) {
        this.crossingResult = crossingResult;
        this.successStateSymbol = successStateSymbol;
        this.successStateWord = successStateWord;
    }

    private static boolean isSameBridgeState(CrossedState crossedState, boolean crossingResult) {
        return crossedState.crossingResult == crossingResult;
    }

    public static CrossedState findByCrossingResult(boolean crossingResult) {
        return Arrays.stream(CrossedState.values())
                .filter(crossingState -> isSameBridgeState(crossingState, crossingResult))
                .findAny().orElseThrow(NoSuchElementException::new);
    }

    public static String getSuccessOrNot(boolean crossingResult) {
        CrossedState crossedState = findByCrossingResult(crossingResult);
        if (crossedState == null) {
            throw new NullPointerException();
        }
        return crossedState.successStateWord;
    }

    public static String transform(boolean crossingResult) {
        CrossedState crossedState = findByCrossingResult(crossingResult);
        if (crossedState == null) {
            throw new NullPointerException();
        }
        return crossedState.successStateSymbol;
    }
}
