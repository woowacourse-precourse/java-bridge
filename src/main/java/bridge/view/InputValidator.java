package bridge.view;

import java.util.List;

public class InputValidator {

    static void validateBridgeSize(int size) {
        final int BRIDGE_SIZE_MIN_INCLUSIVE = 3;
        final int BRIDGE_SIZE_MAX_INCLUSIVE = 20;

        if (BRIDGE_SIZE_MIN_INCLUSIVE > size || size > BRIDGE_SIZE_MAX_INCLUSIVE) {
            throw new IllegalArgumentException(
                    String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                            BRIDGE_SIZE_MIN_INCLUSIVE,
                            BRIDGE_SIZE_MAX_INCLUSIVE));
        }
    }

    static void validateMoving(String moving) {
        final String UP = "U";
        final String DOWN = "D";

        if (!List.of(UP, DOWN).contains(moving)) {
            throw new IllegalArgumentException("이동할 칸은 U(위), D(아래) 중 하나여야 합니다.");
        }
    }

    static void validateGameCommand(String gameCommand) {
        final String QUIT = "Q";
        final String RETRY = "R";

        if (!List.of(QUIT, RETRY).contains(gameCommand)) {
            throw new IllegalArgumentException("게임 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나여야 합니다.");
        }
    }
}
