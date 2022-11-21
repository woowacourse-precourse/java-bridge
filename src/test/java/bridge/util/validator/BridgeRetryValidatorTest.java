package bridge.util.validator;

import bridge.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeRetryValidatorTest {

    @Test
    @DisplayName("재시작 입력 예외 테스트_1")
    void retryBridgeTest1() {
        assertThatThrownBy(() -> new BridgeRetryValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_RETRY_EMPTY);
    }

    @Test
    @DisplayName("재시작 입력 예외 테스트_2")
    void retryBridgeTest2() {
        assertThatThrownBy(() -> new BridgeRetryValidator("QR"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_RETRY_RIGHT_LENGTH);
    }

    @Test
    @DisplayName("재시작 입력 예외 테스트_3")
    void retryBridgeTest3() {
        assertThatThrownBy(() -> new BridgeRetryValidator("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_RETRY_RIGHT_FORM);
    }
}