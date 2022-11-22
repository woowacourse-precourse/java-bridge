package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ValueSource(ints = {3, 8, 11, 20})
    @ParameterizedTest
    public void 다리생성_성공(int size) {
        Assertions.assertThatCode(() -> bridgeMaker.makeBridge(size)).doesNotThrowAnyException();
    }
}
