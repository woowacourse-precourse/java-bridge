package bridge;

import java.util.regex.Pattern;

public class Validation {
    public static void isPositiveInteger(String bridgeSize) {
        String pattern = "^[1-9]+[0-9]{0,8}$";
        if (!Pattern.matches(pattern, bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 10억 미만의 양의 정수이어야 합니다.");
        }
    }

    public static void isInRange(int bridgeSize) {
        if (!(3 <= bridgeSize && bridgeSize <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void validateMoveTo(String position) {
        if (!(position.equals("U") || position.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] : 이동할 다리는 위(U) 또는 아래(D) 이어야 합니다.");
        }
    }

    public static void validateRestart(String restartGame) {
        if (!(restartGame.equals("Q") || restartGame.equals("R"))) {
            throw new IllegalArgumentException("[ERROR] : 재시도 여부는 종료(Q) 또는 재시도(R) 이어야 합니다.");
        }
    }
}
