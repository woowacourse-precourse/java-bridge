package exceptionHandler;

import enumCollections.ExceptionMessage;
import enumCollections.Side;

import java.util.List;

public class BridgeGenerationException {
    public static void validate(List<String> movableSides) {
        movableSides.stream()
                .forEach(side -> {
                    validateSideSelection(side);
                });
    }

    private static void validateSideSelection(String side) {
        if (!Side.isBridgeSavingFormat(side)) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.SELECT_SIDE));
        }
    }
}
