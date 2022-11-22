package bridge;

import bridge.service.BridgeMaker;
import bridge.service.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @Test
    @DisplayName("다리를 생성하는 테스트")
    void makeBridge() {
        // given
        int expectedValue = 3;

        // when
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> result = bridgeMaker.makeBridge(expectedValue);

        // then
        assertThat(result.size()).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("CustomBridgeRandomNumberGenerator 를 사용하여 다리를 생성하는 테스트")
    void custom_makeBridge() {
        // given
        int size = 3;
        List<String> expectedValues = List.of("U", "U", "U");

        // when
        BridgeMaker bridgeMaker = new BridgeMaker(new CustomBridgeRandomNumberGenerator());
        List<String> result = bridgeMaker.makeBridge(size);

        // then
        assertThat(expectedValues).isEqualTo(result);
    }
}