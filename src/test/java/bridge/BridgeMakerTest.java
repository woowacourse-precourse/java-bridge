package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @DisplayName("다리를 정해진 길이만큼 생성해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 20})
    void 다리를_길이만큼_생성한다(int size) {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge.size()).isEqualTo(size);
    }

    @DisplayName("다리 길이가 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 21})
    void 다리_길이가_범위를_벗어나면_예외가_발생한다(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리는 이동할 수 있는 칸이 표시되어 있다.")
    @Test
    void 다리는_이동할_수_있는_칸이_표시되어_있다() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        List<String> bridge = bridgeMaker.makeBridge(3);

        // then
        assertThat(bridge).containsAnyOf("U", "D");
    }

}