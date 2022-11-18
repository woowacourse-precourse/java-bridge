package view;

import java.util.Arrays;

public class Validation {
    public void validate(String input, String message) {
        validateEmpty(input);
        validateContainBlank(input);
        Arrays.stream(InputMessage.values())
                .filter(inputMessage -> message.equals(inputMessage.getMessage()))
                .forEach(inputMessage -> inputMessage.validation(input));
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

    public void validateBridgeSizeRange(String input) {
        if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20) {
            throw new IllegalArgumentException("다리의 길이는 3 이상 20 이하여야 합니다.");
        }
    }

    public void validateMoving(String input){
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("이동할 칸의 입력은 'U' 또는 'D'가 되어야 합니다.");
        }
    }
    public void validateRetryCode(String input){
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("재시도 여부의 입력은 'R' 또는 'Q'가 되어야 합니다.");
        }
    }
}