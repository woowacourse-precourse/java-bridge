package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @DisplayName("1, 0 값들이 주어질 때 D, U로 이루어진 다리를 반환")
    @Test
    void makeBridge() {
        BridgeNumberGenerator generator = new TestBridgeNumberGenerator(newArrayList(1, 0, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        List<String> bridge = bridgeMaker.makeBridge(6);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D", "U");
    }

    @DisplayName("다리 숫자 중 1, 0이외의 숫자가 주어질 때 예외 발생")
    @Test
    void makeBridgeIllegalNumber() {
        BridgeNumberGenerator generator = new TestBridgeNumberGenerator(newArrayList(3, 0, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 숫자 값은 1 or 0만 가능합니다.");
    }
}
