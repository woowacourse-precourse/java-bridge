package bridge.domain.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum CrossingState {
    POSSIBLE(true, "O", "성공"),
    IMPOSSIBLE(false, "X", "실패");
    private final boolean crossingResult;
    private final String successStateSymbol;
    private final String successStateWord;

    CrossingState(boolean crossingResult, String successStateSymbol, String successStateWord) {
        this.crossingResult = crossingResult;
        this.successStateSymbol = successStateSymbol;
        this.successStateWord = successStateWord;
    }

    private static boolean isSameBridgeState(CrossingState crossingState, boolean crossingResult) {
        return crossingState.crossingResult == crossingResult;
    }

    public static CrossingState findByCrossingResult(boolean crossingResult) {
        return Arrays.stream(CrossingState.values())
                .filter(crossingState -> isSameBridgeState(crossingState, crossingResult))
                .findAny().orElseThrow(NoSuchElementException::new);
    }

    public static String getSuccessOrNot(boolean crossingResult) {
        CrossingState crossingState = findByCrossingResult(crossingResult);
        if (crossingState == null) {
            throw new NullPointerException();
        }
        return crossingState.successStateWord;
    }

    public static String transform(boolean crossingResult) {
        CrossingState crossingState = findByCrossingResult(crossingResult);
        if (crossingState == null) {
            throw new NullPointerException();
        }
        return crossingState.successStateSymbol;
    }
}
