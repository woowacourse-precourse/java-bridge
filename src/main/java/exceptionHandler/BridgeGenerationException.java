package exceptionHandler;

import java.util.List;

public class BridgeGenerationException extends InputException {
    public static void validate(List<String> movableSides) {
        movableSides.stream()
                .forEach(side -> {
                    validateSideSelection(side);
                    validateCharactersOnly(side);
                });
    }
}
