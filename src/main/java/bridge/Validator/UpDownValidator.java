package bridge.Validator;

import java.util.List;

public interface UpDownValidator {
    default boolean isCorrectMove(String input) {
        return List.of("U", "D").contains(input);
    }
}
