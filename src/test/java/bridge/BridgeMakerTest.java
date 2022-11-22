package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ValueSource(ints = {3, 8, 11, 20})
    @ParameterizedTest
    public void 다리_생성(int size) {
        Assertions.assertThatCode(() -> bridgeMaker.makeBridge(size)).doesNotThrowAnyException();
    }

    @ValueSource(ints = {-30, -1, 0, 2, 21, 30})
    @ParameterizedTest
    public void 다리_생성_예외(int size) {
        Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(size)).isInstanceOf(IllegalArgumentException.class);
    }
}