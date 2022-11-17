package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void makeBridgeSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> strings = bridgeMaker.makeBridge(3);

        assertThat(strings.size()).isEqualTo(3);
    }

}