package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.utils.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeTest {
    private static final int MIN = 3;
    private static final int MAX = 20;

    @ParameterizedTest
    @DisplayName("다리 길이가 정수가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1.3", "12a", " ", "1 4"})
    void createBridgeSizeByNotInteger(String input) {
        assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BRIDGE_SIZE_NOT_INTEGER);
    }

    @ParameterizedTest
    @DisplayName("다리 길이가 " + MIN + "미만 혹은 " + MAX + "초과이면 예외가 발생한다.")
    @ValueSource(strings = {"-1", "2", "21", "+58"})
    void createBridgeSizeByOutOfRange(String input) {
        assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BRIDGE_SIZE_OUT_OF_RANGE);
    }
}