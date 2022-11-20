package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
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
    @DisplayName("getMatchMoving 메서드는 숫자 값을 입력받아")
    class describe_getMatchMoving_Integer {

        @Test
        @DisplayName("알맞은 MoveChoice 객체를 반환한다.")
        void returnMovingTest() {
            assertThat(MoveChoice.getMatchChoice(UP_NUMBER)).isEqualTo(MoveChoice.UP);
            assertThat(MoveChoice.getMatchChoice(DOWN_NUMBER)).isEqualTo(MoveChoice.DOWN);
        }

        @Test
        @DisplayName("유효하지 않은 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> MoveChoice.getMatchChoice(ERROR_NUMBER)).isInstanceOf(NoSuchElementException.class);
        }
    }

    @Nested
    @DisplayName("getMatchMoving 메서드는 문자열을 입력받아")
    class describe_getMatchMoving_String {

        @Test
        @DisplayName("알맞은 MoveChoice 객체의 getPositionNumber 값을 반환한다.")
        void returnMovingTest() {
            assertThat(MoveChoice.getMatchChoice(UP_MOVING)).isEqualTo(MoveChoice.UP);
            assertThat(MoveChoice.getMatchChoice(DOWN_MOVING)).isEqualTo(MoveChoice.DOWN);
        }

        @Test
        @DisplayName("유효하지 않은 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> MoveChoice.getMatchChoice(ERROR_MOVING)).isInstanceOf(NoSuchElementException.class);
        }
    }
}
