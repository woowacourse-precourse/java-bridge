package exceptionHandler;

import enumCollections.ExceptionMessage;
import enumCollections.Side;

import java.util.List;

public class BridgeGenerationException extends InputException {
    public static void validate(List<String> movableSides) {
        validateCommonException(String.join("", movableSides));
        validateMinimumRange(movableSides.size());
        validateMaximumRange(movableSides.size());
        movableSides.stream()
                .forEach(side -> validateEachSide(side));
    }

    protected static void validateEachSide(String side) {
        validateCommonException(side);
        validateSideSelection(side);
        validateCharactersOnly(side);
    }

    private static void validateSideSelection(String side) {
        if (!Side.isBridgeSavingFormat(side)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_SELECTED_SIDE.getMessage());
        }
    }
}