package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("입력된 크기의 길이를 가진 다리를 생성한다")
    @ValueSource(ints = {3, 5, 7})
    @ParameterizedTest
    void makeBridgeWithCorrectInputSize(int size) {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge.size()).isEqualTo(size);
    }

    @DisplayName("입력된 크기가 조건에 맞지 않으면 예외가 발생한다.")
    @ValueSource(ints = {1, 21, -5})
    @ParameterizedTest
    void makeBridgeWithWrongInputSize(int size) {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when, then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}