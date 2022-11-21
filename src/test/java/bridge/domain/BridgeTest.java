package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeTest {
    @DisplayName("특정위치에서 다리가 같으면 true")
    @Test
    void checkSameBridgeByIndex1() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        boolean result = bridge.contain(2, "D");
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("특정위치에서 다리가 다르면 false")
    @Test
    void checkSameBridgeByIndex2() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        boolean result = bridge.contain(0, "D");
        assertThat(result).isEqualTo(false);
    }


    @DisplayName("같은 다리이면 true")
    @Test
    void checkSameBridge1() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        boolean result = bridge.isSame(List.of("U", "D", "D"));
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("다른 다리이면 false")
    @Test
    void checkSameBridge2() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        boolean result = bridge.isSame(List.of("U", "D"));
        assertThat(result).isEqualTo(false);
    }


    @DisplayName("다리의 길이가 20보다 큰 경우")
    @Test
    void makeBridgeByMoreThan20() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(21);
        assertThatThrownBy(
                () -> new Bridge(bridge)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 3보다 작은 경우")
    @Test
    void makeBridgeByLessThan3() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(2);
        assertThatThrownBy(
                () -> new Bridge(bridge)).isInstanceOf(IllegalArgumentException.class);
    }
}
