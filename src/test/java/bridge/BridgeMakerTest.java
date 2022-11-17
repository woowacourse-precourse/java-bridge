package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private BridgeMaker maker;

    @BeforeEach
    void createGenerator() {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        maker = new BridgeMaker(generator);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @DisplayName("Bridge length 에 맞춰서 U와 D로 이루어진 다리를 생성하여 반환한다.")
    void makeBridge(int bridgeLength) {
        List<String> bridge = maker.makeBridge(bridgeLength);
        assertThat(bridge.size()).isEqualTo(bridgeLength);
        assertThat(String.join("", bridge)).matches("[UD]+");
    }
}