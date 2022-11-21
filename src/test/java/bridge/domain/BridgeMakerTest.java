package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BridgeMakerTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("makeBridge 메소드 테스트")
    class MakeBridge {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 브리지_생성_시_리스트가_잘_반환되는지_테스트(int size, List<Integer> target, List<String> expected) {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(target);
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(size);
            assertThat(bridge.equals(expected)).isTrue();
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(0, newArrayList(), newArrayList()),
                    Arguments.of(1, newArrayList(1), newArrayList("U")),
                    Arguments.of(3, newArrayList(1, 0, 0), newArrayList("U", "D", "D")),
                    Arguments.of(3, newArrayList(1, 1, 1), newArrayList("U", "U", "U")),
                    Arguments.of(4, newArrayList(1, 1, 1, 1), newArrayList("U", "U", "U", "U"))
            );
        }
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