package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.BridgeSize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeSizeTest {
    @ParameterizedTest(name = "입력한 다리의 길이만큼 다리를 생성한다")
    @CsvSource("3,4,5,6,7,8,9,20")
    void makeBridge(int size) {
        BridgeSize bridgeSize = new BridgeSize(size);
        assertThat(bridgeSize.getSize()).isEqualTo(size);
    }

    @ParameterizedTest(name = "입력한 다리의 길이가 유효하지 않으면 오류가 발생한다")
    @CsvSource("2,21,,0,3.3")
    void makeBridgeThrowsError(int size) {
        assertThatThrownBy(() -> new BridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리의 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}