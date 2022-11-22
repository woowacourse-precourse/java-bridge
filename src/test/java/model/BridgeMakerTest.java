package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.model.constant.MoveDirection;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    private final int BRIDGE_SIZE = 4;
    private final int UP_NUMBER = MoveDirection.UP.getDirectionNumber();
    private final int DOWN_NUMBER = MoveDirection.DOWN.getDirectionNumber();

    private final String UP_STRING = MoveDirection.UP.getDirectionString();
    private final String DOWN_STRING = MoveDirection.DOWN.getDirectionString();

    @Nested
    @DisplayName("makeBridge 메서드는 다리의 길이를 입력받아")
    class describe_makeBridge {

        @Test
        @DisplayName("해당 길이만큼의 문자열 리스트를 반환한다.")
        void returnMovingTest() {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(
                    new ArrayList<>(List.of(UP_NUMBER, UP_NUMBER, DOWN_NUMBER, DOWN_NUMBER)));
            bridgeMaker = new BridgeMaker(numberGenerator);
            assertThat(bridgeMaker.makeBridge(BRIDGE_SIZE)).isEqualTo(
                    List.of(UP_STRING, UP_STRING, DOWN_STRING, DOWN_STRING));
        }

        class TestNumberGenerator implements BridgeNumberGenerator {

            private List<Integer> numbers;

            TestNumberGenerator(List<Integer> numbers) {
                this.numbers = numbers;
            }

            @Override
            public int generate() {
                return this.numbers.remove(0);
            }
        }
    }

}
