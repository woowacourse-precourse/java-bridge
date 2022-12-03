package bridge;

import bridge.domain.model.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

    @Test
    @DisplayName("다리 생성 테스트")
    public void createBridge(){
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }
    @Test
    @DisplayName("다리 생성 예외 테스트")
    public void createWrongBridge(){
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 2, -1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThatThrownBy(()->bridgeMaker.makeBridge(3)).isInstanceOf(NoSuchElementException.class);
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
