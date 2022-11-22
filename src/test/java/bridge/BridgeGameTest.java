package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {
    BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(3);
    BridgeGame bridgeGame = new BridgeGame(bridge); // U D D

    @DisplayName("입력한 다리 선택이 List<String> choice에 담긴다")
    @Test
    @Order(1)
    void move_테스트() {
        bridgeGame.move("U");
        List<String> choice = bridgeGame.getChoice();
        Assertions.assertThat(choice).isEqualTo(Arrays.asList("U"));
    }

    @Order(2)
    @DisplayName("재시도 시 다리 선택을 담은 List<String> choice가 비워진다")
    @Test
    void retry_테스트() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.retry();
        Assertions.assertThat((bridgeGame.getChoice()).isEmpty()).isTrue();
    }

    @Order(3)
    @DisplayName("다리 선택과 bridge를 비교하여 일부 일치하는 경우 true, 하나라도 다른경우 false를 반환한다.")
    @Test
    void isRightChoice_test() {
        bridgeGame.retry();
        bridgeGame.move("U");
        Assertions.assertThat(bridgeGame.isRightChoice()).isTrue();

        bridgeGame.move("U");
        Assertions.assertThat(bridgeGame.isRightChoice()).isFalse();
    }

    @Order(4)
    @DisplayName("다리 선택과 bridge를 비교하여 전부 일치하는 경우 true, 다른경우 false를 반환한다.")
    @Test
    void isBridgeSuccess() {
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        Assertions.assertThat(bridgeGame.isBridgeSuccess()).isTrue();
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {
        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {return numbers.remove(0);}

    }
}