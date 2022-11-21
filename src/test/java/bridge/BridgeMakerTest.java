package bridge;

import bridge.model.generator.BridgeMaker;
import bridge.model.generator.BridgeNumberGenerator;
import bridge.model.generator.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

    @Test
    public void 숫자생성기가_범위_밖의_숫자를_생성할_때_예외_발생(){
        int wrongInput = 100;
        BridgeNumberGenerator numberGenerator = new BridgeMakerTest.TestNumberGenerator(newArrayList(0, 0, wrongInput));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
    }

    @Test
    public void 생성된_숫자에_따른_문자열_리스트_생성(){
        BridgeNumberGenerator numberGenerator = new BridgeMakerTest.TestNumberGenerator(newArrayList(1, 0, 0));
        int size = 3;
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge).containsExactly("U", "D", "D");
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
