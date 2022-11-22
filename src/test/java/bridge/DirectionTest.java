package bridge;

import bridge.domain.Direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @DisplayName("0과 1을 U와 D로 변환")
    @Test
    void changeInputMoveToOutputMove() {
        assertThat(Direction.of(0)).isEqualTo(Direction.DOWN);
        assertThat(Direction.of(1)).isEqualTo(Direction.UP);
    }


    @DisplayName("0과 1이 아닌 값이 들어올 경우 예외 발생")
    @Test
    void inputExceptionRandomNumber() {
        assertThatThrownBy(() -> Direction.of(4)).isInstanceOf(IllegalArgumentException.class);
    }
}
