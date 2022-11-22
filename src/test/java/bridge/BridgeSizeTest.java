package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BridgeSizeTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ValueSource(strings = {"ABC", "-1"})
    @ParameterizedTest
    void 입력_예외_테스트(String userBridgeSize) {
        assertThatThrownBy(() -> new BridgeSize(userBridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 반환_테스트() {
        BridgeSize bridgeSize = new BridgeSize("15");
        assertThat(bridgeSize.getBridgeSize()).isEqualTo(15);
    }

}