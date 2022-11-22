package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    private static final BridgeMaker bridgeMaker = new BridgeMaker(
            new BridgeRandomNumberGenerator());

    @Test
    @DisplayName("다리는 U와 D로 이루어져있습니다.")
    void bridgeMakerTest() {
        List<String> bridge = bridgeMaker.makeBridge(8);

        assertThat(bridge).containsAnyOf("U", "D");
    }
}
