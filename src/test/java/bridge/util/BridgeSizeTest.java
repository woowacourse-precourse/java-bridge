package bridge.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {
    @DisplayName("다리 길이는 3 이상 20 이하이다.")
    @ParameterizedTest
    @ValueSource( ints = {3, 11, 20})
    void 다리_길이_범위_정상처리(int size) {
        assertDoesNotThrow(() -> BridgeSize.findByRange(size));
    }

    @DisplayName("다리 길이 범위가 유효하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, -1, 22})
    void 다리_길이_범위_테스트(int bridgeSize) {
        assertThatThrownBy(() -> BridgeSize.findByRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}