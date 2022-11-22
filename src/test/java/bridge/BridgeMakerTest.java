package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    BridgeNumberGenerator numberGenerator;
    BridgeMaker bridgeMaker;
    int bridgeSize;

    @BeforeEach
    void setUp() {
        numberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeSize = 10;
    }

    @AfterEach
    void afterEach() {
        numberGenerator = null;
        bridgeMaker = null;
    }

    @DisplayName("다리가 랜덤 생성이 정상적으로 되는 지 확인한다.")
    @Test
    void createRandomBridge() {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Assertions.assertThat(bridge)
                .containsAnyOf("U", "D")
                .hasSize(bridgeSize);
    }
}