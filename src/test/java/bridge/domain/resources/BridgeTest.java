package bridge.domain.resources;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    Bridge bridge;

    @DisplayName("다리가 잘 생성되는지 사이즈로 확인하는 테스트")
    @ValueSource(ints = {3, 4, 5, 6, 20})
    @ParameterizedTest
    void bridgeSizeTest(int inputSize) {
        bridge = Bridge.of(inputSize);
        Assertions.assertThat(bridge.getBridge().size()).isEqualTo(inputSize);
    }

    @DisplayName("3 ~ 20 범위 외의 정수를 입력했을 때 예외 메시지를 던지는지 테스트")
    @ValueSource(ints = {-1, 0, -20, 21, 123})
    @ParameterizedTest
    void bridgeWrongSizeTest(int wrongInputSize) {
        Assertions.assertThatThrownBy(() -> bridge = Bridge.of(wrongInputSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}