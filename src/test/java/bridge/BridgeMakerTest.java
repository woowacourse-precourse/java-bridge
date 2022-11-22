package bridge;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리가 제대로 생성되는지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 7, 11, 15})
    void makeBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Assertions.assertThat(bridge.size()).as("개수 반환이 제대로 되는지 확인").isEqualTo(bridgeSize);
        Assertions.assertThat(
                Collections.frequency(bridge, "U") + Collections.frequency(bridge, "D")
                ).as("U와 D의 개수 합이 전체 개수와 일치 하는지 확인").isEqualTo(bridgeSize);

    }
}