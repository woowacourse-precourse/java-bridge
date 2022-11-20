package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.enums.MoveChoice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MoveChoiceTest {

    private static final int UP_NUMBER = MoveChoice.UP.positionNumber;
    private static final int DOWN_NUMBER = MoveChoice.DOWN.positionNumber;
    private static final String UP_MOVING = MoveChoice.UP.moving;
    private static final String DOWN_MOVING = MoveChoice.DOWN.moving;
    private static final int ERROR_NUMBER = 10;
    private static final String ERROR_MOVING = "u";


    @Nested
    @DisplayName("getMoving 메서드는 숫자 값을 입력받아")
    class describe_getMoving {

        @Test
        @DisplayName("알맞은 MoveChoice 객체의 moving 문자열을 반환한다.")
        void returnMovingTest() {
            assertThat(MoveChoice.getMoving(UP_NUMBER)).isEqualTo(MoveChoice.UP.moving);
            assertThat(MoveChoice.getMoving(DOWN_NUMBER)).isEqualTo(MoveChoice.DOWN.moving);
        }

        @Test
        @DisplayName("유효하지 않은 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> MoveChoice.getMoving(ERROR_NUMBER)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("getPositionNumber 메서드는 문자열을 입력받아")
    class describe_getPositionNumber {

        @Test
        @DisplayName("알맞은 MoveChoice 객체의 getPositionNumber 값을 반환한다.")
        void returnMovingTest() {
            assertThat(MoveChoice.getPositionNumber(UP_MOVING)).isEqualTo(MoveChoice.UP.positionNumber);
            assertThat(MoveChoice.getPositionNumber(DOWN_MOVING)).isEqualTo(MoveChoice.DOWN.positionNumber);
        }

        @Test
        @DisplayName("유효하지 않은 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> MoveChoice.getPositionNumber(ERROR_MOVING)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
