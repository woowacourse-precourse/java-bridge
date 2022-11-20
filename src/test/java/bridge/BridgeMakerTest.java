package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    @Test
    void canPassTest() {
        BridgeUtils bridgeUtils = new BridgeUtils();
        String DorU = bridgeUtils.canPass(1);

        assertThat(DorU).isEqualTo("U");
    }
}
