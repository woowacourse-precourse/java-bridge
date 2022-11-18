package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("다리 생성 시, 다리 길이 유효 숫자 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 21})
    void validateBridgeSize(int size) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 유효 숫자 범위 내 길이 지정 시, 해당 길이의 다리 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void makeBridgePerSize(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }
}