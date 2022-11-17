package bridge.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum ValidationType {
    CHECK_SIZE(Arrays.stream(IntStream.rangeClosed(3, 20).toArray())
            .boxed().map(String::valueOf)
            .collect(Collectors.toList())),
    CHECK_MOVING(List.of("U", "D")),
    CHECK_GAME_COMMAND(List.of("R", "Q"));

    private List<String> validationRange;

    ValidationType(List<String> validationRange) {
        this.validationRange = validationRange;
    }

    private List<String> getValidationRange() {
        return validationRange;
    }

    public boolean validate(ValidationType validationType, String input) {
        return validationType.getValidationRange().contains(input);
    }
}
