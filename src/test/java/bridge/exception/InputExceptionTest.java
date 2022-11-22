package bridge.exception;

import org.junit.jupiter.api.Test;

import static bridge.exception.InputException.*;
import static org.assertj.core.api.Assertions.*;

class InputExceptionTest {
    static final String NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    static final String BRIDGE_SIZE_RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    static final String MOVING_ERROR_MESSAGE = "[ERROR] U(위 칸) 또는 D(아래 칸) 중 하나를 입력해주세요.";
    static final String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] R(게임 재시작) 또는 Q(게임 종료) 중 하나를 입력해주세요.";

    @Test
    void 다리길이입력시_숫자를입력하지않았을경우_예외발생() {
        String input = "U";
        assertThatThrownBy(() -> checkIsBridgeSizeInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER_ERROR_MESSAGE);
    }

    @Test
    void 다리길이입력시_숫자범위를벗어났을경우_예외발생() {
        int input = 55;
        assertThatThrownBy(() -> checkBridgeSizeRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BRIDGE_SIZE_RANGE_ERROR_MESSAGE);
    }

    @Test
    void 이동하는칸을잘못입력했을경우_예외발생() {
        String input = "P";
        assertThatThrownBy(() -> checkMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MOVING_ERROR_MESSAGE);
    }

    @Test
    void 게임재시작종료명령어를잘못입력했을경우_예외발생() {
        String input = "A";
        assertThatThrownBy(() -> checkGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GAME_COMMAND_ERROR_MESSAGE);
    }
}