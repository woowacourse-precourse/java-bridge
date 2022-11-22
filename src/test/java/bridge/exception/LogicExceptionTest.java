package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LogicExceptionTest {

    @DisplayName("다리 입력값은 3이상 20이하 정수여야 합니다.")
    @Test
    void verifyBridgeSizeTest() {
        String bridgeSize = "200";
        assertThatThrownBy(() -> LogicException.verifyBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U, D가 아닌 다른 문자가 들어왔을 때 예외")
    @Test
    void verifyUserInputTest() {
        String upOrDown = "W";
        assertThatThrownBy(() -> LogicException.verifyUserInput(upOrDown))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작을 위한 R, 종료를 위한 Q가 아니면 예외")
    @Test
    void verifyRetryOrQuitTest() {
        String retryOrQuit = "C";
        assertThatThrownBy(() -> LogicException.verifyRetryOrQuit(retryOrQuit))
                .isInstanceOf(IllegalArgumentException.class);
    }
}