package bridge.validator;

import java.util.function.Predicate;

public enum InputValidator implements Validator<String> {

    IS_NUMBER(
            "입력값이 정수가 아닙니다.",
            (String input) -> {
                try {
                    Integer.parseInt(input);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }),
    IS_UPPERCASE_ALPHABET(
            "입력값이 대문자가 아닙니다.",
            (String input) ->
                    input.chars()
                            .map(i -> (char) i)
                            .allMatch(Character::isUpperCase)
    ),
    ;

    private final String errorMessage;
    private final Predicate<String> predicate;

    InputValidator(String errorMessage, Predicate<String> predicate) {
        this.errorMessage = errorMessage;
        this.predicate = predicate;
    }

    @Override
    public String getErrorMessage() {
        return prefix + errorMessage;
    }

    @Override
    public boolean test(String target) {
        return predicate.test(target);
    }
}
