package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BridgeMarkerTest {
    List<String> randomBridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(3);

    @DisplayName("다리 길이 대로 생성되는지 확인한다.")
    @Test
    void checkBridgeSize() {
        assertThat(randomBridge.size()).isEqualTo(3);
    }
}
