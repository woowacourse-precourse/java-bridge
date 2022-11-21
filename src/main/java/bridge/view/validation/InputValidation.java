package bridge.view.validation;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public enum InputValidation {
    BLANK(
            "아무것도 입력하지 않으셨습니다.",
            String::isBlank,
            List.of("readBridgeSize", "readMoving", "readGameCommand")
    ),
    NOT_NUMBER(
            "숫자가 아닙니다.",
            input -> !input.matches("^[0-9]+$"),
            List.of("readBridgeSize")
    ),
    NOT_3_TO_20(
            "다리 길이는 3부터 20 사이의 숫자여야 합니다.",
            input -> !input.matches("^[3-9]$|^1[0-9]$|^20$"),
            List.of("readBridgeSize")
    ),
    NOT_U_OR_D(
            "U 또는 D를 입력해주세요.",
            input -> input.matches("^[^UD]$"),
            List.of("readMoving")
    ),
    NOT_R_OR_Q(
            "R 또는 Q를 입력해주세요.",
            input -> input.matches("^[^RQ]$"),
            List.of("readGameCommand")
    );

    private final String errorMessage;
    private final Function<String, Boolean> expression;
    private final List<String> validationGroup;
    public static final boolean VALIDATED = false;

    InputValidation(String errorMessage, Function<String, Boolean> expression, List<String> validationGroup) {
        this.errorMessage = errorMessage;
        this.expression = expression;
        this.validationGroup = validationGroup;
    }

    private String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }

    private static Optional<InputValidation> validate(String input, String validationGroup) {
        return Stream.of(values())
                .filter(enumType -> enumType.validationGroup.contains(validationGroup))
                .filter(enumType -> enumType.expression.apply(input))
                .findFirst();
    }

    public static boolean checkValidation(String input, String validationGroup) {
        Optional<InputValidation> validation = validate(input, validationGroup);
        try {
            if (validation.isPresent())
                throw new IllegalArgumentException();
            return VALIDATED;
        } catch (IllegalArgumentException e) {
            System.out.println(validation.get().getErrorMessage());
        }
        return !VALIDATED;
    }
}
