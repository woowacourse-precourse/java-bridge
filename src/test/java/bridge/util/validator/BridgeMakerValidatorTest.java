package bridge.util.validator;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerValidatorTest {

    private static String error = "[ERROR]";
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    @DisplayName("다리 생성의 예외 테스트_1")
    void createBridgeTest1() {
        assertThatThrownBy(() -> new BridgeMakerValidator("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("다리 생성의 예외 테스트_2")
    void createBridgeTest2() {
        assertThatThrownBy(() -> new BridgeMakerValidator("2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("다리 생성의 예외 테스트_3")
    void createBridgeTest3() {
        assertThatThrownBy(() -> new BridgeMakerValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("다리 생성의 예외 테스트_4")
    void createBridgeTest4() {
        assertThatThrownBy(() -> new BridgeMakerValidator("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("다리 생성 메서드 makeBridge 사전 테스트1")
    void makeBridgeTest1() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    @DisplayName("다리 생성 메서드 makeBridge 사전 테스트2")
    void makeBridgeTest2() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(6);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D", "U");
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}