package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @Test
    @DisplayName("생성 크기 테스트")
    void makeTest() {
        BridgeMaker randomMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = randomMaker.makeBridge(5);
        assertThat(bridge.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("생성된 다리 문자열 테스트")
    void makeStringTypeTest() {
        BridgeMaker randomMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = randomMaker.makeBridge(10);
        System.out.println("bridge = " + bridge);
        assertThat(bridge.get(0)).containsAnyOf("U", "D");
        assertThat(bridge.get(1)).containsAnyOf("U", "D");
        assertThat(bridge.get(2)).containsAnyOf("U", "D");
        assertThat(bridge.get(3)).containsAnyOf("U", "D");
        assertThat(bridge.get(4)).containsAnyOf("U", "D");
        assertThat(bridge.get(5)).containsAnyOf("U", "D");
        assertThat(bridge.get(6)).containsAnyOf("U", "D");
        assertThat(bridge.get(7)).containsAnyOf("U", "D");
        assertThat(bridge.get(8)).containsAnyOf("U", "D");
        assertThat(bridge.get(9)).containsAnyOf("U", "D");
    }

    @Test
    @DisplayName("생성 예외(크기 2) 테스트")
    void makeInvalid2Test() {
        BridgeMaker randomMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        Assertions.assertThatThrownBy(() -> randomMaker.makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성 예외(크기 21) 테스트")
    void makeInvalid21Test() {
        BridgeMaker randomMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        Assertions.assertThatThrownBy(() -> randomMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}