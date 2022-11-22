package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("입력 받은 길이만큼의 다리 생성 확인")
    @ValueSource(ints = {3, 4, 5})
    @ParameterizedTest
    void makeBridge(int size) {
        assertThat(bridgeMaker.makeBridge(size).size())
                .isEqualTo(size);
    }
}
