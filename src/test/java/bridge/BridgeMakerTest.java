package bridge;

import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리 만드는 함수 테스트")
    @Test
    void makeBridgeTest() {
        int size = 3;
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge).contains("U", "D");
        assertAll(
            () -> assertThat(bridge).containsOnly("U", "D"),
            () -> assertThat(bridge.size()).isEqualTo(size)
        );
    }
}
