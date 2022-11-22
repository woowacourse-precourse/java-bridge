package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;
    BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void setUp() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("랜덤으로 생성한 bridge 길이 확인")
    @Test
    void sizeTest() {
        int size = 5;
        List<String> bridge = bridgeMaker.makeBridge(5);

        Assertions.assertThat(bridge.size()).isEqualTo(size);
    }
}