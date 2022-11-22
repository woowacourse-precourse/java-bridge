package bridge.domain.bridge;

import bridge.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {
    BridgeNumberGenerator numberGenerator;
    BridgeMaker bridgeMaker;

    @Nested
    @DisplayName("다리 생성 테스트")
    class makeBridgeTest {

        @Test
        @DisplayName("0, 0 입력 -> D D 출력")
        void 케이스1() {
            // given
            ArrayList<Integer> input = newArrayList(0, 0);
            // when
            updateBridgeMaker(input);
            List<String> result = bridgeMaker.makeBridge(2);
            // then
            assertThat(result).containsExactly("D", "D");
        }

        @Test
        @DisplayName("0, 1 입력 -> D U 출력")
        void 케이스2() {
            // given
            ArrayList<Integer> input = newArrayList(0, 1);
            // when
            updateBridgeMaker(input);
            List<String> result = bridgeMaker.makeBridge(2);
            // then
            assertThat(result).containsExactly("D", "U");
        }

        @Test
        @DisplayName("1, 0 입력 -> U D 출력")
        void 케이스3() {
            // given
            ArrayList<Integer> input = newArrayList(1, 0);
            // when
            updateBridgeMaker(input);
            List<String> result = bridgeMaker.makeBridge(2);
            // then
            assertThat(result).containsExactly("U", "D");
        }

        @Test
        @DisplayName("1, 1 입력 -> U U 출력")
        void 케이스4() {
            // given
            ArrayList<Integer> input = newArrayList(1, 1);
            // when
            updateBridgeMaker(input);
            List<String> result = bridgeMaker.makeBridge(2);
            // then
            assertThat(result).containsExactly("U", "U");
        }

    }

    @Test
    @DisplayName("지정된 사이즈만큼의 리스트를 만들어내는지 검증")
    void 사이즈_검증() {
        // given
        ArrayList<Integer> input = newArrayList(1, 1);
        int lstSize = 2;
        // when
        updateBridgeMaker(input);
        List<String> result = bridgeMaker.makeBridge(lstSize);
        // then
        assertThat(result.size()).isEqualTo(2);
    }

    private void updateBridgeMaker(ArrayList<Integer> input) {
        updateNumberGenerator(input);
        bridgeMaker = new BridgeMaker(numberGenerator);
    }

    private void updateNumberGenerator(ArrayList<Integer> input) {
        numberGenerator = new TestNumberGenerator(input);
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