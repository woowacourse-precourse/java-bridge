package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.BridgeLength;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeLengthTest {
    @ParameterizedTest(name = "입력한 다리의 길이만큼 다리를 생성한다")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 20})
    void makeBridge(int length) {
        BridgeLength bridgeLength = new BridgeLength(length);
        assertThat(bridgeLength.getLength()).isEqualTo(length);
    }

    @ParameterizedTest(name = "입력한 다리의 길이가 유효하지 않으면 오류가 발생한다")
    @ValueSource(ints = {2, 21, 0})
    void makeBridgeThrowsError(int length) {
        assertThatThrownBy(() -> new BridgeLength(length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리의 길이는 3부터 20 사이의 자연수여야 합니다.");
    }
}