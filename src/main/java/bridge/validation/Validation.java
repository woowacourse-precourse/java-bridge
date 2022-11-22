package bridge;

import java.util.Objects;

public class Validation {
    public static int validateInputBridgeSize(String bridgeSize) {
        int size = validateParesInt(bridgeSize);
        validateRange(size);
        return size;
    }

    public static int validateParesInt(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리의 길이를 숫자로 입력해주세요.");
        }
    }

    public static void validateRange(int bridgeSize) {
        if (bridgeSize > 21 || bridgeSize < 3) {
            throw new IllegalArgumentException("다리의 길이는 3부터 20사이의 숫자입니다.");
        }
    }

    public static void validateMoving(String move) {
        if (!Objects.equals(move, "U") && !Objects.equals(move, "D")) {
            throw new IllegalArgumentException("다리를 건너기 위해 이동할 수 있는 칸은 U(위) / D(아래) 입니다.");
        }

        if (move.length() != 1) {
            throw new IllegalArgumentException("다리를 건너기 위해 위 / 아래 중 한 곳만 선택할 수 있습니다.");
        }
    }

    public static void validateReGame(String message) {
        if (!Objects.equals(message, "R") && !Objects.equals(message, "Q")) {
            throw new IllegalArgumentException("게임을 재시작하려면 R / 종료하려면 Q를 입력하세요.");
        }

        if (message.length() != 1) {
            throw new IllegalArgumentException("게임 재시작 / 종료에 대한 입력값을 하나만 입력해주세요.");
        }
    }
}
