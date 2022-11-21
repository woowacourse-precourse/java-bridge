package util;

public class InputValidator {
    public void validateNumberType(String input) {
        boolean isNumber = input.chars().allMatch(Character::isDigit);

        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }
}
