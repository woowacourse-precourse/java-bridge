package bridge.validation;

import java.util.regex.Pattern;

public class Validation {

    public void validateBridgeSizeInput(String input) {
        checkEmpty(input);
        isNumeric(input);
        isSizeInBound(Integer.parseInt(input), 3, 20);
    }

    public boolean isvValidBridgeSizeInput(String input) {
        try {
            validateBridgeSizeInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void validateMoving(String input) {
        checkEmpty(input);
        isAlphabetic(input);
        isMovingCommand(input);
    }

    public boolean isValidMoveInput(String input) {
        try {
            validateMoving(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void validateGameCommand(String input) {
        checkEmpty(input);
        isAlphabetic(input);
        isGameCommand(input);
    }

    public boolean isValidGameCommand(String input) {
        try {
            validateGameCommand(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void checkEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] null을 입력받았습니다.");
        }

        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private void isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (str == null) {
            throw new IllegalArgumentException("[ERROR] 길이가 1 이상이여야 합니다.");
        }
        if (!pattern.matcher(str).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하여야 합니다.");
        }
    }

    private void isAlphabetic(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("[ERROR] 알파벳만을 입력하여야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] \"U\" 또는 \"D\"만 입력가능합니다.");
        }
    }

    private void isGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] \"R\" 또는 \"Q\"만 입력가능합니다.");
        }
    }
}
