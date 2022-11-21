package exceptionHandler;

import java.util.List;

public class BridgeGenerationException extends InputException {
    public static void validate(List<String> movableSides) {
        movableSides.stream()
                .forEach(side -> {
                    validate(side);
                });
    }

    public static void validate(String side) {
        validateSideSelection(side);
        validateCharactersOnly(side);
    }
}
