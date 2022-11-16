package bridge.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LogicExceptionTest {

    @DisplayName("다리 입력값은 3이상 20이하 정수여야 합니다.")
    @Test
    void verifyBridgeSizeTest() {
        String bridgeSize = "200";
        assertThatThrownBy(() -> LogicException.verifyBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}