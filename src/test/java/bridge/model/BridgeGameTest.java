package bridge.model;

import bridge.BridgeNumberGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.model.BridgePosition.BRIDGE_POSITION_UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("BridgeGame를 테스트한다.")
class BridgeGameTest {

    @DisplayName("다음 위치와 사용자의 입력이 주어지면 다음 위치와 비교해서, 움직가능 여부를 판단한다.")
    @Test
    void judgeMoveIfMoveable() {
        //given
        BridgeGame bridgeGame = BridgeGame.of(3, new TestNumberGenerator(Lists.newArrayList(1, 0, 0)));

        //when
        //then
        assertAll(
                () -> assertThat(bridgeGame.move(0, BRIDGE_POSITION_UP.getCommand())).isTrue(),
                () -> assertThat(bridgeGame.move(1, BRIDGE_POSITION_UP.name())).isFalse(),
                () -> assertThat(bridgeGame.move(2, BRIDGE_POSITION_UP.name())).isFalse()
        );
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