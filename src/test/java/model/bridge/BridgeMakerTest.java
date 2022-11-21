package model.bridge;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeMakerTest {

    BridgeMaker maker;

    @BeforeEach
    void setUp() {
        maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("입력한 다리 크기만큼 다리 생성")
    @ValueSource(strings = {"3", "5", "15", "20"})
    @ParameterizedTest(name = "[{index}]  size : {0}")
    void makeBridge(Integer size) {
        List<String> bridge = maker.makeBridge(size);
        assertThat(bridge).hasSize(size);
    }

    @DisplayName("다리가 U 또는 D로만 구성")
    @ValueSource(strings = {"3", "5", "15", "20"})
    @ParameterizedTest(name = "[{index}]  size : {0}")
    void bridgeMark(Integer size) {
        List<String> bridge = maker.makeBridge(size);
        assertTrue(bridge.stream().allMatch(b -> b.equals("U") || b.equals("D")));
    }
}