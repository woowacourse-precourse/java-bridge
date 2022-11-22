package util;

import java.util.Set;

public class InputValidator {
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final Set<String> MOVE_COMMAND = Set.of("U", "D");
    public static final Set<String> RETRY_COMMAND = Set.of("R", "Q");

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

    public void validateRetryOrQuit(String input) {
        if (!RETRY_COMMAND.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 재시도 선택은 R 또는 Q 만 입력할 수 있습니다.");
        }
    }

    public void validateSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
