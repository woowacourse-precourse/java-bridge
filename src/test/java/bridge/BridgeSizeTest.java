package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeSizeTest {
    @DisplayName("숫자가 아닌 값이 입력되면 예외를 발생한다.")
    @Test
    void createBridgeSizeByNoNumber() {
        assertThatThrownBy(() -> new BridgeSize("ABC"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 숫자가 입력되면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "2", "21"})
    void createBridgeSizeByOutOfRangeNumber(String outOfRangeNumber) {
        assertThatThrownBy(() -> new BridgeSize(outOfRangeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}