package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Collections;
import java.util.List;

class BridgeMakerTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 20})
    @DisplayName("만든 다리에 대한 길이 테스트")
    void makeBridge_length3To20_ReturnString(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(Collections.frequency(bridge, "U") + Collections.frequency(bridge, "D"))
                .isEqualTo(size);
    }
}