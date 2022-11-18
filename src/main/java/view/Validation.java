package view;

public class Validation {
    public void validate(String input) {
        validateEmpty(input);
    }

    public void validateEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }
    }
}
