package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.domain.Move.*;
import static org.assertj.core.api.Assertions.*;

class MoveTest {
    @DisplayName("입력으로 'U'가 들어오면 UP, 'D'가 들어오면 DOWN을 반환한다.")
    @Test
    public void moveInputTest() {
        assertThat(Move.from("U")).isEqualTo(UP);
        assertThat(Move.from("D")).isEqualTo(DOWN);
    }

    @DisplayName("입력으로 'U' 또는 'D' 이외의 값이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"u", "d", "", "q", "U ", "Ud", "1", "*"})
    @ParameterizedTest
    public void moveBadInputTest(String input) {
        assertThatThrownBy(() -> Move.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("other()는 다른 Move를 반환한다.")
    @Test
    public void otherMoveTest() {
        assertThat(other(UP)).isEqualTo(DOWN);
    }

    @DisplayName("convertDirection()은 1이면 UP, 0이면 DOWN을 반환한다.")
    @Test
    public void convertDirectionTest() {
        assertThat(Move.convertDirection(1)).isEqualTo(UP.direction);
        assertThat(Move.convertDirection(0)).isEqualTo(DOWN.direction);
    }

    @DisplayName("convertDirection()는 0 또는 1 이외의 숫자가 들어오면 예외가 발생한다.")
    @ValueSource(ints = {-1, 2, 3, 4})
    @ParameterizedTest(name = "{index}. number = {0}")
    public void convertDirectionThrowExceptionTest(int number) {
        assertThatThrownBy(() -> Move.convertDirection(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}