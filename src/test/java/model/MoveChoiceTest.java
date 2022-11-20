package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MoveChoiceTest {

    private static final int UP_MOVE = MoveChoice.UP.positionNumber;
    private static final int DOWN_MOVE = MoveChoice.DOWN.positionNumber;
    private static final int ERROR_MOVE = 10;

    @Nested
    @DisplayName("getMoving 메서드는 숫자 값을 입력받아")
    class describe_getMoving {

        @Test
        @DisplayName("알맞은 MoveChoice 객체의 moving 문자열을 반환한다.")
        void returnMovingTest(){
            assertThat(MoveChoice.getMoving(UP_MOVE)).isEqualTo(MoveChoice.UP.moving);
            assertThat(MoveChoice.getMoving(DOWN_MOVE)).isEqualTo(MoveChoice.DOWN.moving);
        }

        @Test
        @DisplayName("유효하지 않은 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest(){
            assertThatThrownBy(() -> MoveChoice.getMoving(ERROR_MOVE)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
