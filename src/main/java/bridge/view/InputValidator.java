package bridge.view;

import static bridge.domain.BridgeGame.DOWN_BRIDGE;
import static bridge.domain.BridgeGame.UP_BRIDGE;
import static bridge.view.InputView.*;

import java.util.List;

public class InputValidator {

    void validateBridgeSize(int size) {
        final int BRIDGE_SIZE_MIN_INCLUSIVE = 3;
        final int BRIDGE_SIZE_MAX_INCLUSIVE = 20;

        if (BRIDGE_SIZE_MIN_INCLUSIVE > size || size > BRIDGE_SIZE_MAX_INCLUSIVE) {
            throw new IllegalArgumentException(
                    String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                            BRIDGE_SIZE_MIN_INCLUSIVE,
                            BRIDGE_SIZE_MAX_INCLUSIVE));
        }
    }

    void validateMoving(String moving) {
        if (!List.of(UP_BRIDGE, DOWN_BRIDGE).contains(moving)) {
            throw new IllegalArgumentException(
                    String.format("이동할 칸은 %s(위), %s(아래) 중 하나여야 합니다.",
                            UP_BRIDGE, DOWN_BRIDGE));
        }
    }

    void validateGameCommand(String gameCommand) {
        if (!List.of(RETRY_COMMAND, QUIT_COMMAND).contains(gameCommand)) {
            throw new IllegalArgumentException(
                    String.format("게임 재시작/종료 여부는 %s(재시작)과 %s(종료) 중 하나여야 합니다.",
                            RETRY_COMMAND, QUIT_COMMAND));
        }
    }
}
