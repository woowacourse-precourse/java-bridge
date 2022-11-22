package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {
    Bridge bridge = new Bridge(List.of(Direction.D, Direction.D, Direction.D));

    @ParameterizedTest(name = "index -> {0}")
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("다리를 건너갔는지 확인한다.")
    void isMoved_DirectionEqualsBridgeInSameIndex_True(int index) {
        assertThat(bridge.isMoved(Direction.D, index)).isTrue();
    }

    @Nested
    @DisplayName("다리를 건널 수 있는지 확인하는 테스트")
    class CanMoveTest {
        Stack<Direction> movement = new Stack<>();

        @Test
        @DisplayName("움직일 방향으로 다리를 건널 수 있으면 통과")
        void canMove_MovementEqualsBridgeInSameIndex_True() {
            movement.push(Direction.D);
            assertThat(bridge.canMove(movement)).isTrue();
        }

        @Test
        @DisplayName("movement가 비어있을 때 예외가 발생한다.")
        void canMove_MovementIsEmpty_ExceptionThrown() {
            movement.clear();
            assertThatThrownBy(() -> new Bridge(List.of(Direction.D))
                    .canMove(movement))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
}