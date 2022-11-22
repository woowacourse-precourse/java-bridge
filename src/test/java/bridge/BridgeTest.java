package bridge;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeTest {

    @DisplayName("다리 길이 3 ~ 20이 아닌 경우, 다리 생성 예외 테스트")
    @ValueSource(ints = {0, 1, 2, 21})
    @ParameterizedTest
    void notValidBridgeSize(int input) {
        assertThatThrownBy(() -> new Bridge(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(BRIDGE_SIZE_ERROR));
    }
}
