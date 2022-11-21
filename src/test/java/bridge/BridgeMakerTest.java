package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest(name = "길이가 {0}이면 다리 생성 가능")
    @ValueSource(ints = {3, 20})
    void constructBridge_메서드는_다리_길이를_받아_길이가_3_이상_20_이하인_Bridge를_생성한다(int size) {
        assertThatNoException().isThrownBy(() -> {
            bridgeMaker.constructBridge(size);
        });
    }

    @ParameterizedTest(name = "길이가 {0}이면 다리 생성 불가")
    @ValueSource(ints = {2, 21})
    void constructBridge_메서드는_다리_길이를_받아_3_미만_20_초과면_예외를_던진다(int size) {
        assertThatThrownBy(() -> {
            bridgeMaker.constructBridge(size);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}