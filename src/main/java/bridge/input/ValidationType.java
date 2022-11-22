package bridge.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum ValidationType {
    CHECK_SIZE(Arrays.stream(IntStream.rangeClosed(3, 20).toArray())
            .boxed().map(String::valueOf)
            .collect(Collectors.toList()), "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    CHECK_MOVING(List.of("U", "D"), "[ERROR] U나 D를 입력해주시기 바랍니다."),
    CHECK_GAME_COMMAND(List.of("R", "Q"), "[ERROR] R이나 Q를 입력해주시기 바랍니다.");

    private List<String> validationRange;
    private String errorMessage;

    ValidationType(List<String> validationRange, String errorMessage) {
        this.validationRange = validationRange;
        this.errorMessage = errorMessage;
    }

    public List<String> getValidationRange() {
        return validationRange;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static boolean validate(ValidationType validationType, String input) {
        return validationType.getValidationRange().contains(input);
    }
}
