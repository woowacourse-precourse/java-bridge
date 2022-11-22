package bridge.domain;

import bridge.BridgeMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @Test
    void 위에만_건널수_있는_다리_만들기_커스텀() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new CustomBridgeRandomNumberGenerator());
        List<String> expectedValues = List.of("U", "U", "U");

        // when
        List<String> passBridges = bridgeMaker.makeBridge(expectedValues.size());

        // then
        assertThat(passBridges).isEqualTo(expectedValues);
    }

}