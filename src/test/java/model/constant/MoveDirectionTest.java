package model.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.model.constant.MoveDirection;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MoveDirectionTest {

    private static final int UP_NUMBER = MoveDirection.UP.getDirectionNumber();
    private static final int DOWN_NUMBER = MoveDirection.DOWN.getDirectionNumber();
    private static final String UP_MOVING = MoveDirection.UP.getDirectionString();
    private static final String DOWN_MOVING = MoveDirection.DOWN.getDirectionString();
    private static final int ERROR_NUMBER = 10;
    private static final String ERROR_MOVING = "u";


    @Nested
    @DisplayName("getMatchMoving 메서드는 숫자 값을 입력받아")
    class describe_getMatchMoving_Integer {

        @Test
        @DisplayName("알맞은 MoveDirection 객체를 반환한다.")
        void returnMovingTest() {
            assertThat(MoveDirection.getMatchDirection(UP_NUMBER)).isEqualTo(MoveDirection.UP);
            assertThat(MoveDirection.getMatchDirection(DOWN_NUMBER)).isEqualTo(MoveDirection.DOWN);
        }

        @Test
        @DisplayName("유효하지 않은 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> MoveDirection.getMatchDirection(ERROR_NUMBER)).isInstanceOf(NoSuchElementException.class);
        }
    }

    @Nested
    @DisplayName("getMatchMoving 메서드는 문자열을 입력받아")
    class describe_getMatchMoving_String {

        @Test
        @DisplayName("알맞은 MoveDirection 객체의 getPositionNumber 값을 반환한다.")
        void returnMovingTest() {
            assertThat(MoveDirection.getMatchDirection(UP_MOVING)).isEqualTo(MoveDirection.UP);
            assertThat(MoveDirection.getMatchDirection(DOWN_MOVING)).isEqualTo(MoveDirection.DOWN);
        }

        @Test
        @DisplayName("유효하지 않은 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> MoveDirection.getMatchDirection(ERROR_MOVING)).isInstanceOf(NoSuchElementException.class);
        }
    }
}
