package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeLengthTest {
    @DisplayName("유효한 범위의 다리 길이를 생성한다.")
    @ParameterizedTest ( name = "{index}) bridge length = {0}")
    @ValueSource(ints = { 3, 7, 10, 14, 20 })
    void createBridgeLength(int length) {
        BridgeLength bridgeLength = new BridgeLength(length);
        assertThat(bridgeLength.get()).isEqualTo(length);
    }

    @DisplayName("유효하지 않은 범위의 다리 길이를 생성 시 IllegalArgumentException 에러를 발생시킨다.")
    @ParameterizedTest ( name = "{index}) bridge length = {0}")
    @ValueSource(ints = { 1, 2, 21, 100 })
    void createBridgeLengthWithOutOfRangeLength(int length) {
        assertThatThrownBy(() -> new BridgeLength(length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
