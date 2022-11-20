package bridge;

import java.util.regex.Pattern;
import static bridge.Util.convertStringToInt;

public class Validation {
    public static int isPositiveInteger(String bridgeSize) {
        String pattern = "^[1-9]+[0-9]*$";
        if (!Pattern.matches(pattern, bridgeSize)) {
            throw new IllegalArgumentException("[ERROR} 다리 개수는 양의 정수이어야 합니다.");
        }
        return convertStringToInt(bridgeSize);
    }

    public static void isInRange(int bridgeSize) {
        if (!(3 <= bridgeSize && bridgeSize <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void validateMoveTo(String position) {
        if (!(position.equals("U") || position.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] : 이동할 칸은 위(U) 또는 아래(D) 이어야 합니다.");
        }
    }

    public static void validateContinue(String restartGame) {
        if (!(restartGame.equals("Q") || restartGame.equals("R"))) {
            throw new IllegalArgumentException("[ERROR] : 재시도 여부는 종료(Q) 또는 재시도(R) 이어야 합니다.");
        }
    }
}
