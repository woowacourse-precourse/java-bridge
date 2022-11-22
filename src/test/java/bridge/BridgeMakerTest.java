package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void test_makeBridge() {
        int size = 5;
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge).hasSize(size);
        assertThat(bridge.stream()
                .filter(item -> !item.equals("U"))
                .filter(item -> !item.equals("D"))
                .toArray())
                .isEmpty();
    }
}
