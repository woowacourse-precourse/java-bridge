package bridge;

import java.util.regex.Pattern;

public class Validation {

    public void validateBridgeSizeInput(String input) {
        checkEmpty(input);
        isNumeric(input);
        isSizeInBound(Integer.parseInt(input), 3, 20);
    }

    public void validateMoving(String input) {
        checkEmpty(input);
        isAlphabetic(input);
        isMovingCommand(input);
    }

    public void validateGameCommand(String input) {
        checkEmpty(input);
        isAlphabetic(input);
        isGameCommand(input);
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private void isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (str == null) {
            throw new IllegalArgumentException("길이가 1 이상이여야 합니다.");
        }
        if (!pattern.matcher(str).matches()) {
            throw new IllegalArgumentException("숫자를 입력하여야 합니다.");
        }
    }

    private void isAlphabetic(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("알파벳만을 입력하여야 합니다.");
            }
        }
    }

    private void isSizeInBound(int size, int min, int max) {
        if (size < min) {
            throw new IllegalArgumentException("[ERROR] " + min + "이상이어야 합니다.");
        }
        if (size > max) {
            throw new IllegalArgumentException("[ERROR] " + max + "이하여야 합니다.");
        }
    }

    private void isMovingCommand(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("\"U\" 또는 \"D\"만 입력가능합니다.");
        }
    }

    private void isGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("\"R\" 또는 \"Q\"만 입력가능합니다.");
        }
    }
}
