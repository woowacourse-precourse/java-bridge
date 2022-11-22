package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("입력받은 다리의 길이를 검증 후 다리를 생성하여 길이를 비교한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 9, 20})
    void makeBridgeByValidatedSize(int size) {
        assertThat(bridgeMaker.makeBridge(size).size()).isEqualTo(size);
    }
}
