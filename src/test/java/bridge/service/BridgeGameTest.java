package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));

    @ParameterizedTest(name = "길이가 {0}이면 다리 생성 불가")
    @ValueSource(ints = {2, 21})
    void 길이가_3_미만_20_초과인_다리를_만들면_예외_던지는_기능(int size) {
        assertThatThrownBy(() -> {
            bridgeGame.makeBridge(size);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "길이가 {0}이면 다리 생성 가능")
    @ValueSource(ints = {3, 20})
    void 길이가_3_이상_20_이하인_다리를_만드는_기능(int size) {
        assertThatNoException().isThrownBy(() -> {
            bridgeGame.makeBridge(size);
        });
    }
}