package util;

import java.util.Set;

public class InputValidator {
    public static final Set<String> MOVE_COMMAND = Set.of("U", "D");
    public void validateNumberType(String input) {
        boolean isNumber = input.chars().allMatch(Character::isDigit);

        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    public void validateMove(String input) {
        if (!MOVE_COMMAND.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 만 입력할 수 있습니다.");
        }
    }
}
