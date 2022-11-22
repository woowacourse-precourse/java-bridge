package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    private static BridgeMaker before() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return bridgeMaker;
    }

    @Test
    void 다리_생성_테스트() {
        //given
        BridgeMaker bridgeMaker = before();

        //when
        List<String> bridge = bridgeMaker.makeBridge(3);

        //then
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 다리_생성_테스트_실패_케이스1() {
        BridgeMaker bridgeMaker = before();
        assertThatThrownBy(()->bridgeMaker.makeBridge(2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_생성_테스트_실패_케이스2() {
        BridgeMaker bridgeMaker = before();
        assertThatThrownBy(()->bridgeMaker.makeBridge(21)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트링리스트_생성_테스트() {
        //given
        BridgeMaker bridgeMaker = before();

        //when
        List<String> strings = bridgeMaker.toStringList(List.of(1, 0, 0));

        //then
        assertThat(strings).containsExactly("U", "D", "D");
    }

    @Test
    void 랜덤숫자_생성_테스트() {
        //given
        BridgeMaker bridgeMaker = before();

        //when
        List<Integer> randomNumbers = bridgeMaker.genRandomNumberList(2);

        //then
        assertThat(randomNumbers).isEqualTo(new ArrayList<>(Arrays.asList(1,0)));
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