package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @Test
    @DisplayName("다리의 길이는 3이상 20이하인 숫자여야 한다.")
    void bridgeLengthValidateTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(2));

        assertThrows(IllegalArgumentException.class,
                () -> new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(21));
    }

    @Test
    @DisplayName("지정된 길이만큼 U 혹은 D로만 이루어진 다리를 만든다.")
    void makeBridgeTest() {
        int size = 3;
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge.stream().allMatch(e -> e.equals("U") || e.equals("D"))).isTrue();
    }
}
