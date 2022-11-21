package bridge;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private List<String> strings;

    @BeforeEach
    void setUp() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        strings = bridgeMaker.makeBridge(5);
    }

    @AfterEach
    void tearDown() {
        bridgeMaker = null;
        strings = null;
    }

    @DisplayName("makeBridge 길이 테스트.")
    @Test
    void makeBridgeLengthTest() {
        Assertions.assertThat(strings.size()).isEqualTo(5);
    }

    @DisplayName("makeBridge 요소 테스트.")
    @Test
    void makeBridgeElementsTest() {
        Assertions.assertThat(strings.stream()
                .filter(item -> item.equals("U") || item.equals("D"))
                .count()).isEqualTo(5);
    }
}