package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    @Test
    void canPassTest() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        String DorU = bridgeMaker.canPass(1);

        assertThat(DorU).isEqualTo("U");
    }
}
