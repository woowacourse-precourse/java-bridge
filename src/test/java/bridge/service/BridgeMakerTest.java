package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.interfaceForTest.BridgeNumberGeneratorTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    private final BridgeNumberGeneratorTest bridgeNumberGeneratorTest = new BridgeNumberGeneratorTest();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGeneratorTest);

    @Test
    @DisplayName("다리 생성 테스트")
    public void makeBridgeTest() {
        // given
        int size = 3;

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge.contains(List.of("U", "U", "U")));
    }

    @Test
    @DisplayName("getDirection 테스트")
    public void getDirectionTest() {
        // given
        int numberOfZero = 0;
        int numberOfOne = 1;

        // when
        String result1 = bridgeMaker.getDirection(numberOfZero);
        String result2 = bridgeMaker.getDirection(numberOfOne);

        // then
        assertThat(result1).isEqualTo("D");
        assertThat(result2).isEqualTo("U");
    }
}
