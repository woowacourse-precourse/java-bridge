package bridge.util.validator;

import bridge.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMoveValidatorTest {

    @Test
    @DisplayName("다리 이동 입력 예외 테스트_1")
    void moveBridgeTest1() {
        assertThatThrownBy(() -> new BridgeMoveValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_LOCATION_EMPTY);
    }

    @Test
    @DisplayName("다리 이동 입력 예외 테스트_2")
    void moveBridgeTest2() {
        assertThatThrownBy(() -> new BridgeMoveValidator("UD"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_LOCATION_RIGHT_LENGTH);
    }

    @Test
    @DisplayName("다리 이동 입력 예외 테스트_3")
    void moveBridgeTest3() {
        assertThatThrownBy(() -> new BridgeMoveValidator("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_LOCATION_RIGHT_FORM);
    }
}