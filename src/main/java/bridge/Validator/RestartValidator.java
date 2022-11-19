package bridge.Validator;

import java.util.List;

public interface RestartValidator {
    default boolean isCorrectDecision(String input) {
        return List.of("R","Q").contains(input);
    }
}
