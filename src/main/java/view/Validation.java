package view;

import java.util.Arrays;

public class Validation {
    public void validate(String input, String message) {
        validateEmpty(input);
        validateContainBlank(input);
        Arrays.stream(InputMessage.values())
                .filter(inputMessage -> message.equals(inputMessage.getMessage()))
                .forEach(inputMessage -> inputMessage.eachValidation(input));
    }

    public void validateEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }
    }

    public void validateContainBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력 값에 공백이 포함되지 않아야 합니다.");
        }
    }
}
