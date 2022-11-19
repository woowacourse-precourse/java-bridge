package bridge.DomainTest;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @Mock
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("다리 설계도를 확인한다.")
    @Test
    void bridgeDesignTest() {
        int size_3 = 3;
        int expected = 3;
        assertThat(bridgeMaker.makeBridge(size_3)).hasSize(expected);
    }

}
